package com.raghava.truck_tracking.repositories;


import com.raghava.truck_tracking.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    @Query ("SELECT s FROM Shipment s JOIN FETCH s.customer JOIN FETCH s.driver WHERE s.trackingNumber = :trackingNumber")
    Shipment findByTrackingNumberWithUsers(@Param ("trackingNumber") String trackingNumber);
}