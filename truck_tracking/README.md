

           🚚 Intelligent Supply Chain Tracker

___**A real-time shipment tracking and notification system built with Java, Spring Boot, Kafka, and Microservices architecture.

📦 Track shipments live.
🚨 Notify customers when shipments enter major cities or states.
🕰️ Estimate delivery dates dynamically.

⸻

🧩 Project Overview

This project simulates a real-world supply chain logistics platform like what powers FedEx, UPS, or Amazon deliveries — featuring real-time tracking, location-based notifications, and delivery ETA predictions.

It uses:
	•	🛰️ GPS data simulation (mock lat/longs) sent to Kafka.
	•	📥 Shipment service — consumes GPS data and stores tracking logs.
	•	🔔 Notification service — listens for city/state entry events and sends notifications to customers.

⸻

🛠️ Tech Stack

Layer	Tech
🧑‍💻 Programming Language	Java 17+
⚙️ Backend Framework	Spring Boot
📡 Messaging Queue	Apache Kafka
🗄️ Database (Tracking Logs)	MySQL (or PostgreSQL)
🛳️ Microservices	Spring Boot apps for each service
📜 Build Tool	Maven
📦 Docker Support	(Optional) Docker Compose
☁️ Future Extensions	Twilio (SMS) / SendGrid (Email) API___**


⸻

📂 Project Structure

📦 truck-tracking-system
├── 🛰️ gps-simulator-service         (Kafka producer - simulates GPS location updates)
├── 🚚 shipment-service              (Kafka consumer - logs shipment location updates)
└── 🔔 notification-service          (Kafka consumer - sends notifications on city/state entry)


⸻

🚀 How It Works
	1.	GPS Simulator Service:
	•	Generates random latitude/longitude/speed data every 10 seconds.
	•	Sends this data as a TrackingMessage to the tracking-updates Kafka topic.
	2.	Shipment Service:
	•	Listens to the tracking-updates topic.
	•	Stores incoming tracking logs into MySQL/PostgreSQL database.
	3.	Notification Service:
	•	Listens to the tracking-updates topic.
	•	Detects when a shipment enters a major city (Chicago, NYC) or state (Indiana, Illinois).
	•	Sends a mock notification (prints to console).
	•	Calculates Estimated Delivery Date (ETA) based on location.

⸻

🔥 Key Features
	•	📡 Real-Time Shipment Tracking — GPS pings every few seconds.
	•	🗺️ City/State Geofencing — Detects entry into key cities or states using latitude/longitude bounding boxes.
	•	🔔 Notifications — Sends updates when shipment enters a new region.
	•	🕰️ ETA Prediction — Basic delivery time estimation based on the current location.
	•	🛡️ Microservices Architecture — Decoupled services communicate through Kafka.

⸻

🛠️ How to Run Locally

1. Prerequisites
	•	Docker + Docker Compose (for Kafka + Zookeeper)
	•	Java 17+
	•	Maven
	•	MySQL or PostgreSQL for Shipment Service

⸻

2. Set Up Kafka (Docker Compose)

# docker-compose.yml
version: '3'
services:
  zookeeper:
    image: wurstmeister/zookeeper:3.4.6
    ports:
      - "2181:2181"
  kafka:
    image: wurstmeister/kafka:2.12-2.2.1
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: localhost
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181

docker-compose up -d


⸻

3. Run Each Service

🛰️ GPS Simulator

cd gps-simulator-service
mvn spring-boot:run

🚚 Shipment Service

cd shipment-service
mvn spring-boot:run

🔔 Notification Service

cd notification-service
mvn spring-boot:run


⸻

📡 Kafka Topics

Topic Name	Purpose
tracking-updates	Stream of real-time GPS tracking data


⸻

📖 Example Notification Output

🔔 Notification: Shipment 101 has entered Chicago.
📍 Current Location: (41.881832, -87.623177)
📅 Estimated Delivery Date: Monday, 10 June 2025


⸻

🚀 Future Improvements
	•	📱 Integrate Twilio API for real SMS notifications.
	•	📧 Integrate SendGrid API for email alerts.
	•	🌍 Use real Geocoding APIs (Google, OpenStreetMap) for accurate city/state detection.
	•	📈 Machine Learning model for ETA prediction (based on historical data).
	•	📊 Add Prometheus + Grafana for monitoring microservices.
	•	🐳 Dockerize each service individually.

⸻

👨‍💻 Author
	•	Melam Raghavendra 

⸻

⭐ Star This Repo

If you found this project useful or learned something, please ⭐ star the repo! It helps me grow and motivates me to create more awesome projects like this.

⸻

🚚💨 Real-time Logistics, Real-time Intelligence.

