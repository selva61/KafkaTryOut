package org.example.kafkatryout;

import org.example.kafkatryout.service.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KafkaTryOutApplication {

    private static final Logger logger = LoggerFactory.getLogger(KafkaTryOutApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaTryOutApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaProducerService kafkaProducerService) {
        return args -> {
            logger.info("Application started, sending sample message to Kafka topic");

            // Send a sample message
            kafkaProducerService.sendMessage("Hello Kafka! This is a test message.");

            // Send another message after a short delay
            Thread.sleep(2000);
            kafkaProducerService.sendMessage("This is another test message!");

            logger.info("Sample messages sent to Kafka topic");
        };
    }
}
