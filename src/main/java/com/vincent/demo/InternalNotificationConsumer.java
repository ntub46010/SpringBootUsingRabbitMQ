package com.vincent.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.vincent.demo.Constants.NAME_INTERNAL_NOTIFICATION_QUEUE;

@Component
public class InternalNotificationConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(InternalNotificationConsumer.class);

    @RabbitListener(queues = NAME_INTERNAL_NOTIFICATION_QUEUE)
    public void processMsg(@Payload CommentMsg comment) {
        LOGGER.info("站內通知：{}", comment.getContent());
    }
}
