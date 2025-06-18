# Kafka Spring Boot Demo

This project demonstrates a simple Kafka producer and consumer implementation using Spring Boot.

## Project Structure

- `KafkaTryOutApplication.java`: Main application class that sends sample messages to Kafka on startup
- `config/KafkaConfig.java`: Configuration class that creates the Kafka topic
- `service/KafkaProducerService.java`: Service that sends messages to the Kafka topic
- `service/KafkaConsumerService.java`: Service that consumes messages from the Kafka topic
- `application.properties`: Configuration for Kafka broker, producer, and consumer

## How It Works

1. The application starts and creates the "TestTopic" if it doesn't exist
2. The CommandLineRunner in the main application sends two sample messages to the topic
3. The KafkaConsumerService listens for messages on the topic and prints them when received

## Prerequisites

- Java 17
- Maven
- Kafka broker running on localhost:9092

## Running the Application

1. Start Kafka broker on localhost:9092
2. Build the application: `mvn clean package`
3. Run the application: `java -jar target/KafkaTryOut-0.0.1-SNAPSHOT.jar`

## Expected Output

When the application runs, you should see log messages indicating:
- The application has started
- Messages being sent to the Kafka topic
- Messages being consumed from the Kafka topic

The consumer will print the consumed messages to the console.

## Notes

- This is a simple demonstration with a single topic, producer, and consumer
- The consumer group ID is set to "test-consumer-group"
- The topic has 1 partition and 1 replica (suitable for local development)