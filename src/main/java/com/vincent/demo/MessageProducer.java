package com.vincent.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.vincent.demo.Constants.NAME_COMMENT_NOTIFICATION_DIRECT_EXCHANGE;
import static com.vincent.demo.Constants.NAME_COMMENT_NOTIFICATION_FANOUT_EXCHANGE;

@Component
public class MessageProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNewCommentNotification(CommentMsg comment) {
        String exchange;
        String routingKey;
        if (comment.getMode() == MsgSendMode.DIRECT) {
            exchange = NAME_COMMENT_NOTIFICATION_DIRECT_EXCHANGE;
            routingKey = comment.getRoutingKey();
        } else {
            exchange = NAME_COMMENT_NOTIFICATION_FANOUT_EXCHANGE;
            routingKey = "";
        }

        rabbitTemplate.convertAndSend(
                exchange,
                routingKey,
                comment
        );

        LOGGER.info("{} sends message successfully.", getClass().getSimpleName());
    }
}