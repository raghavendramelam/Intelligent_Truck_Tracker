package com.raghava.truck_tracking;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TrackingMessage {
    private Long shipmentId;
    private Double latitude;
    private Double longitude;
    private Double speed;

    private LocalDateTime eventTime;

    @Override
    public String toString ( ) {
        return "TrackingMessage{" +
                "eventTime=" + eventTime +
                ", shipmentId=" + shipmentId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", speed=" + speed +
                '}';
    }


}
