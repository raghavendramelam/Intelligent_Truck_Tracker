package com.raghava.truck_tracking.dtos;

import java.time.LocalDateTime;

public class ShipmentDetails {


    private String origin;
    private String destination;
    private String status;

    public String getUserName ( ) {
        return userName;
    }

    public void setUserName ( String userName ) {
        this.userName = userName;
    }

    private String userName;
    public LocalDateTime getEstimatedDeliveryDate ( ) {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate ( LocalDateTime estimatedDeliveryDate ) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private LocalDateTime estimatedDeliveryDate;

    public ShipmentDetails() {
    }

    public ShipmentDetails( String origin, String destination, String status) {

        this.origin = origin;
        this.destination = destination;
        this.status = status;
    }



    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
