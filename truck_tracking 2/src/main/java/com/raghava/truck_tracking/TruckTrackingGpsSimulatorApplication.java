package com.raghava.truck_tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableKafka
public class TruckTrackingGpsSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruckTrackingGpsSimulatorApplication.class, args);
	}

}
