package com.vincent.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);
    private final Map<Integer, String> userNameMap = Map.of(1, "Vincent", 2, "Dora");
    private final Map<Integer, String> postNameMap = Map.of(1, "2023 週年慶", 2, "iPhone 15 週邊上架");

    @RabbitListener(queues = "Comment Notification Queue")
    public void processMsg(@Payload CommentMsg comment) {
        LOGGER.info("{} receives message successfully.", getClass().getSimpleName());

        String userName = getUserName(comment.getCreatorId());
        String postTitle = getPostTitle(comment.getPostId());

        LOGGER.info("站內通知：{}在文章「{}」上留言", userName, postTitle);
        LOGGER.info("信件主旨：文章「{}」有新留言", postTitle);
        LOGGER.info("信件內容：{}在「{}」上留言：{}", userName, postTitle, comment.getContent());
    }

    private String getUserName(int userId) {
        return userNameMap.get(userId);
    }

    private String getPostTitle(int itemId) {
        return postNameMap.get(itemId);
    }
}
