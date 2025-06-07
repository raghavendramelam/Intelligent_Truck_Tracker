package com.raghava.truck_tracking.repositories;


import com.raghava.truck_tracking.entities.Shipment;
import com.raghava.truck_tracking.entities.TrackingLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackingLogRepository extends JpaRepository<TrackingLog, Long> {
    List<TrackingLog> findByShipmentId(Long shipmentId);

    List<TrackingLog> findByShipment ( Shipment shipment );

    @Query ("SELECT t FROM TrackingLog t " +
            "JOIN FETCH t.shipment s " +
            "JOIN FETCH s.customer " +
            "JOIN FETCH s.driver " +
            "WHERE s = :shipment")
    List<TrackingLog > findTrackingLogsWithShipmentAndUsers ( Long shipmentId );
}