package com.raghava.truck_tracking.controller;

import com.raghava.truck_tracking.dtos.ShipmentDetails;
import com.raghava.truck_tracking.dtos.TrackingDto;
import com.raghava.truck_tracking.entities.Shipment;
import com.raghava.truck_tracking.entities.TrackingLog;
import com.raghava.truck_tracking.service.IShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final IShipmentService shipmentService;

    public ShipmentController(IShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ResponseEntity<ShipmentDetails> createShipment(@RequestBody ShipmentDetails shipmentDetails) {
        ShipmentDetails createdShipment = shipmentService.createShipment(shipmentDetails);
        return ResponseEntity.ok(createdShipment);
    }

    @GetMapping("/{trackingNumber}")
    public ResponseEntity<Shipment> getShipmentByTrackingNumber(@PathVariable String trackingNumber) {
        Shipment shipment = shipmentService.getShipmentByTrackingNumber(trackingNumber);
        return ResponseEntity.ok(shipment);
    }

    @PostMapping("/{shipmentId}/tracking-logs")
    public ResponseEntity<TrackingDto> addTrackingLog(@PathVariable Long shipmentId, @RequestBody TrackingDto trackingDto) {
        TrackingDto addedLog = shipmentService.addTrackingLog(shipmentId, trackingDto);
        return ResponseEntity.ok(addedLog);
    }

    @GetMapping("/{shipmentId}/tracking-logs")
    public ResponseEntity<List<TrackingDto>> getTrackingLogs( @PathVariable Long shipmentId) {
        List<TrackingDto> trackingLogs = shipmentService.getTrackingLogs(shipmentId);
        return ResponseEntity.ok(trackingLogs);
    }
}