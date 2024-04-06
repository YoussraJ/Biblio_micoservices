package com.yosra.Emprunt.producer_consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

@Service
@RequiredArgsConstructor
@Slf4j
public class VerifyUser {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private MonoSink<String> verificationResultSink;

    @KafkaListener(topics = "verifyUserResultTopic", groupId = "myGroup")
    public void verifyUserResult(String result) {
        // Process the verification result here
        log.info("Received verification result: {}", result);
        if (verificationResultSink != null) {
            verificationResultSink.success(result);
        }
    }

    public Mono<String> verifyUser(String userId) {
        return Mono.create(sink -> {
            verificationResultSink = sink;
            log.info("Sending userId {} for verification", userId);
            kafkaTemplate.send("verifyUserTopic", userId);
        });
    }
}
