package com.raghava.truck_tracking.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrackingDto {

    private Double latitude;
    private Double longitude;
    private Double speed;
    private LocalDateTime eventTime;
    private String driverName;
    private String customerName;
    private  String trackingNumber;
}
