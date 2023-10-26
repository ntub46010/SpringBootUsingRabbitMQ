package com.vincent.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.vincent.demo.Constants.NAME_COMMENT_NOTIFICATION_ROUTING_EXCHANGE;
import static com.vincent.demo.Constants.NAME_COMMENT_NOTIFICATION_TOPIC_EXCHANGE;

@Component
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNewCommentNotification(CommentMsg comment) {
        String exchange = "";
        if (comment.getMode() == MsgSendMode.ROUTING) {
            exchange = NAME_COMMENT_NOTIFICATION_ROUTING_EXCHANGE;
        } else if (comment.getMode() == MsgSendMode.TOPIC){
            exchange = NAME_COMMENT_NOTIFICATION_TOPIC_EXCHANGE;
        }

        rabbitTemplate.convertAndSend(exchange, comment.getRoutingKey(), comment);
    }
}