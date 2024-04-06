package com.yosra.user.consumer;

import com.yosra.user.user.User;
import com.yosra.user.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class userVerifyForEmprunt {
    private final UserRepository userRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "verifyUserTopic", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info("Consuming the message from verifyUserTopic Topic:: {}", msg);

        // Parse the message to an integer
        Integer userId;
        try {
            userId = Integer.parseInt(msg);
            log.info("hhhhhhh {}", userId);
        } catch (NumberFormatException e) {
            log.error("Invalid user ID format: {}", msg);
            return; // Exit if the user ID format is invalid
        }

        // Check if the user exists in the database and send verification result
        userRepository.findById(userId)
                .flatMap(user -> {
                    log.info("User with ID {} found: {}", userId, user);
                    return sendVerificationResult("verified");
                })
                .switchIfEmpty(sendVerificationResult("not verified"))
                .subscribe();
    }

    private Mono<Void> sendVerificationResult(String result) {
        return Mono.fromRunnable(() -> kafkaTemplate.send("verifyUserResultTopic", result));
    }
}
