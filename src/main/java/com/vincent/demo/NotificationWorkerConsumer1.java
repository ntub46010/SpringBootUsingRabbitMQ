package com.vincent.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NotificationWorkerConsumer1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationWorkerConsumer1.class);

    @RabbitListener(queues = "Comment Notification Queue")
    public void processMsg(@Payload CommentMsg comment) {
        LOGGER.info("{} receives message successfully.", getClass().getSimpleName());
    }
}
