package com.vincent.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.vincent.demo.Constants.NAME_EMAIL_NOTIFICATION_QUEUE;

@Component
public class EmailNotificationConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailNotificationConsumer.class);

    @RabbitListener(queues = NAME_EMAIL_NOTIFICATION_QUEUE)
    public void processMsg(@Payload CommentMsg comment) {
        LOGGER.info("Email 通知：{}", comment.getContent());
    }
}
