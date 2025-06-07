package com.raghava.truck_tracking.kafka;

import com.raghava.truck_tracking.dtos.TrackingMessage;
import com.raghava.truck_tracking.entities.Shipment;
import com.raghava.truck_tracking.entities.TrackingLog;
import com.raghava.truck_tracking.repositories.ShipmentRepository;
import com.raghava.truck_tracking.repositories.TrackingLogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipmentTrackingListener {

    private final ShipmentRepository shipmentRepository;
    private final TrackingLogRepository trackingLogRepository;
    public ShipmentTrackingListener(ShipmentRepository shipmentRepository, TrackingLogRepository trackingLogRepository) {
        this.shipmentRepository = shipmentRepository;
        this.trackingLogRepository = trackingLogRepository;
    }

    @KafkaListener(topics = "tracking_updates", groupId = "tracking-log-consumer")
    public void consume( TrackingMessage trackingMessage ){
 Optional<Shipment> shipment= shipmentRepository.findById(trackingMessage.getShipmentId());

  Shipment shipment1 =shipment.orElseThrow(() -> new RuntimeException("Shipment not found with ID: " + trackingMessage.getShipmentId()));

        TrackingLog log = new TrackingLog();
        log.setShipment(shipment1);
        log.setLatitude(trackingMessage.getLatitude());
        log.setLongitude(trackingMessage.getLongitude());
        log.setSpeed(trackingMessage.getSpeed());
        log.setEventTime(trackingMessage.getEventTime());

        trackingLogRepository.save(log);

        System.out.println("✅ Saved new TrackingLog from Kafka: " + log);
    }
}
