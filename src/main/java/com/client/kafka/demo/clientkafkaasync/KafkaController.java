package com.client.kafka.demo.clientkafkaasync;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class KafkaController {

    @Autowired
    public final KafkaService kafkaService;

    @GetMapping("/tes-async/{id}")
    public ResponseEntity<Object> tes(@PathVariable("id") String id) throws Exception {

        log.info("incoming data = {}", id);

        String responseString = (String) kafkaService.kafkaRequestReply(id);
        log.info("Request message: {}, Response message: {}", id, responseString);

        Map<String, String> mapJson = new HashMap<>();
        mapJson.put("ResponseCode", "00");
        mapJson.put("ResponseDesc", "success");
        mapJson.put("Data", responseString);
        return ResponseEntity.ok(mapJson);
    }
}
