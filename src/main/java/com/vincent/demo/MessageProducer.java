package com.vincent.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNewCommentNotification(CommentMsg comment) {
        rabbitTemplate.convertAndSend("Comment Notification Queue", comment);
        LOGGER.info("{} sends message successfully.", getClass().getSimpleName());
    }
}
