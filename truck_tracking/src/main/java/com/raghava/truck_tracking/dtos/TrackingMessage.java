package com.raghava.truck_tracking.dtos;

import java.time.LocalDateTime;

public class TrackingMessage {
    private Long shipmentId;
    private Double latitude;
    private Double longitude;
    private Double speed;

    public LocalDateTime getEventTime ( ) {
        return eventTime;
    }

    public void setEventTime ( LocalDateTime eventTime ) {
        this.eventTime = eventTime;
    }

    public Double getLatitude ( ) {
        return latitude;
    }

    public void setLatitude ( Double latitude ) {
        this.latitude = latitude;
    }

    public Double getLongitude ( ) {
        return longitude;
    }

    public void setLongitude ( Double longitude ) {
        this.longitude = longitude;
    }

    public Long getShipmentId ( ) {
        return shipmentId;
    }

    public void setShipmentId ( Long shipmentId ) {
        this.shipmentId = shipmentId;
    }

    public Double getSpeed ( ) {
        return speed;
    }

    public void setSpeed ( Double speed ) {
        this.speed = speed;
    }

    private LocalDateTime eventTime;
}
