package com.client.kafka.demo.clientkafkaasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ClientKafkaAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientKafkaAsyncApplication.class, args);
    }

}
