package com.raghava.truck_tracking.service;

import com.raghava.truck_tracking.dtos.ShipmentDetails;
import com.raghava.truck_tracking.dtos.TrackingDto;
import com.raghava.truck_tracking.entities.Shipment;
import com.raghava.truck_tracking.entities.TrackingLog;
import com.raghava.truck_tracking.repositories.ShipmentRepository;
import com.raghava.truck_tracking.repositories.TrackingLogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShipmentServiceImpl implements IShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final TrackingLogRepository trackingLogRepository;

    public ShipmentServiceImpl ( ShipmentRepository shipmentRepository, TrackingLogRepository trackingLogRepository ) {
        this.trackingLogRepository = trackingLogRepository;
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public ShipmentDetails createShipment ( ShipmentDetails shipmentDetails ) {
        Shipment shipment = new Shipment();
        BeanUtils.copyProperties(shipmentDetails, shipment);

        // Generate and set tracking number
        shipment.setTrackingNumber(UUID.randomUUID().toString());

        // Save shipment
        shipment = shipmentRepository.save(shipment);

        // Convert back to DTO (including generated fields like ID and tracking number)
        ShipmentDetails response = new ShipmentDetails();
        BeanUtils.copyProperties(shipment, response);

        return response;
    }

    @Override
    public Shipment getShipmentByTrackingNumber ( String trackingNumber ) {
        Shipment shipment = shipmentRepository.findByTrackingNumberWithUsers(trackingNumber);

        if (shipment == null) {
            throw new RuntimeException("Shipment not found with tracking number: " + trackingNumber);
        }
        return shipment;
    }

    @Override
    public TrackingDto addTrackingLog ( Long shipmentId, TrackingDto logDto ) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(( ) -> new RuntimeException("Shipment not found with ID: " + shipmentId));

        TrackingLog trackingLog = new TrackingLog();
        BeanUtils.copyProperties(logDto, trackingLog);

        // ❗ Set the shipment (VERY IMPORTANT)
        trackingLog.setShipment(shipment);

        trackingLogRepository.save(trackingLog);

        return logDto;
    }


    @Override
    public List<TrackingDto> getTrackingLogs ( Long shipmentId ) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(( ) -> new RuntimeException("Shipment not found with ID: " + shipmentId));

        // Fetch tracking logs along with shipment and users eagerly
        List<TrackingLog> trackingLogs = trackingLogRepository.findTrackingLogsWithShipmentAndUsers(shipmentId);

        // Convert entities to DTOs
        List<TrackingDto> trackingDtos = trackingLogs.stream().map(log -> {
            TrackingDto dto = new TrackingDto();
            dto.setLatitude(log.getLatitude());
            dto.setLongitude(log.getLongitude());
            dto.setSpeed(log.getSpeed());
            dto.setEventTime(log.getEventTime());
            dto.setDriverName(log.getShipment().getDriver().getUsername());
            dto.setCustomerName(log.getShipment().getCustomer().getUsername());
            dto.setTrackingNumber(log.getShipment().getTrackingNumber());
            return dto;
        }).toList(); // if using Java 17+, else use .collect(Collectors.toList())

        return trackingDtos;
    }
}