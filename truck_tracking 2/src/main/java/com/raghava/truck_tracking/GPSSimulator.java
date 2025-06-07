package com.raghava.truck_tracking;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GPSSimulator {

    private final KafkaTemplate<String, TrackingMessage> kafkaTemplateService;

    @Value ("${app.kafka.topic.shipment}")
    private String topic;

    private Long shipmentId = 1L;
    private double lat = 39.7684;
    private double lon = -86.1581;
    @Scheduled(fixedRate = 600000)
    public void sendTrackingMessage() {
        lat += Math.random() * 0.001;
        lon += Math.random() * 0.001;

        TrackingMessage message = new TrackingMessage();
        message.setShipmentId(shipmentId);
        message.setLatitude(lat);
        message.setLongitude(lon);
        message.setSpeed(50 + Math.random() * 10);
        message.setEventTime(LocalDateTime.now());
        kafkaTemplateService.send(topic, message);


        System.out.println("🚚 Sent Tracking Update: " + message);


    }
}
