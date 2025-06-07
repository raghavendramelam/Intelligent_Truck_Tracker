package com.raghava.truck_tracking.service;

import com.raghava.truck_tracking.dtos.ShipmentDetails;
import com.raghava.truck_tracking.dtos.TrackingDto;
import com.raghava.truck_tracking.entities.Shipment;
import com.raghava.truck_tracking.entities.TrackingLog;

import java.util.List;

public interface IShipmentService {

    /**
     * Creates a new shipment with the given details.
     *
     * @param shipmentDetails The details of the shipment to create.
     * @return The created shipment.
     */
    ShipmentDetails createShipment( ShipmentDetails shipmentDetails);

    /**
     * Retrieves a shipment by its tracking number.
     *
     * @param trackingNumber The tracking number of the shipment to retrieve.
     * @return The shipment with the specified tracking number.
     */
    Shipment getShipmentByTrackingNumber(String trackingNumber);


    TrackingDto addTrackingLog( Long shipmentId, TrackingDto log);
    /**
     * Retrieves the tracking logs for a specific shipment.
     *
     * @param shipmentId The ID of the shipment for which to retrieve tracking logs.
     * @return A list of tracking logs associated with the specified shipment.
     */
    List<TrackingDto> getTrackingLogs( Long shipmentId);
}
