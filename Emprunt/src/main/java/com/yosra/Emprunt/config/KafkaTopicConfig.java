package com.yosra.Emprunt.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic verifyUserTopic() {
        return TopicBuilder
                .name("verifyUserTopic")
                .build();
    }


    @Bean
    public NewTopic resultVerificationTopic() {
        return TopicBuilder
                .name("verifyUserResultTopic")
                .build();
    }
}
