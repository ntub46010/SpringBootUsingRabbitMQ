package com.vincent.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue commentNotificationQueue() {
        return new Queue("Comment Notification Queue");
    }
}
