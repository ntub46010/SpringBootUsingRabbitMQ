package com.vincent.demo;

public class Constants {
    private Constants() {}

    public static final String BEAN_INTERNAL_NOTIFICATION_QUEUE = "internalNotification";
    public static final String BEAN_EMAIL_NOTIFICATION_QUEUE = "emailNotification";
    public static final String BEAN_COMMENT_NOTIFICATION_ROUTING_EXCHANGE = "commentNotificationRoutingExchange";
    public static final String BEAN_COMMENT_NOTIFICATION_TOPIC_EXCHANGE = "commentNotificationTopicExchange";

    public static final String NAME_INTERNAL_NOTIFICATION_QUEUE = "Comment Internal Notification Queue";
    public static final String NAME_EMAIL_NOTIFICATION_QUEUE = "Comment Email Notification Queue";
    public static final String NAME_COMMENT_NOTIFICATION_ROUTING_EXCHANGE = "Comment Notification Routing Exchange";
    public static final String NAME_COMMENT_NOTIFICATION_TOPIC_EXCHANGE = "Comment Notification Topic Exchange";
}
