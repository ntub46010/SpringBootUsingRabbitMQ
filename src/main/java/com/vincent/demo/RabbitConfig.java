package com.vincent.demo;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.vincent.demo.Constants.*;

@Configuration
public class RabbitConfig {

    @Bean(name = BEAN_INTERNAL_NOTIFICATION_QUEUE)
    public Queue internalNotificationQueue() {
        return new Queue(NAME_INTERNAL_NOTIFICATION_QUEUE);
    }

    @Bean(name = BEAN_EMAIL_NOTIFICATION_QUEUE)
    public Queue emailNotificationQueue() {
        return new Queue(NAME_EMAIL_NOTIFICATION_QUEUE);
    }

    @Bean(name = BEAN_COMMENT_NOTIFICATION_ROUTING_EXCHANGE)
    public DirectExchange commentNotificationRoutingExchange() {
        return new DirectExchange(NAME_COMMENT_NOTIFICATION_ROUTING_EXCHANGE);
    }

    @Bean
    public Binding bindInternalNotificationQueueToRoutingExchangeForPostComment(
            @Qualifier(BEAN_INTERNAL_NOTIFICATION_QUEUE) Queue queue,
            @Qualifier(BEAN_COMMENT_NOTIFICATION_ROUTING_EXCHANGE) DirectExchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange).with("post.comment");
    }

    @Bean
    public Binding bindInternalNotificationQueueToRoutingExchangeForProductComment(
            @Qualifier(BEAN_INTERNAL_NOTIFICATION_QUEUE) Queue queue,
            @Qualifier(BEAN_COMMENT_NOTIFICATION_ROUTING_EXCHANGE) DirectExchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange).with("product.comment");
    }

    @Bean
    public Binding bindEmailNotificationQueueToRoutingExchangeForProductComment(
            @Qualifier(BEAN_EMAIL_NOTIFICATION_QUEUE) Queue queue,
            @Qualifier(BEAN_COMMENT_NOTIFICATION_ROUTING_EXCHANGE) DirectExchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange).with("product.comment");
    }

    @Bean(name = BEAN_COMMENT_NOTIFICATION_TOPIC_EXCHANGE)
    public TopicExchange commentNotificationTopicExchange() {
        return new TopicExchange(NAME_COMMENT_NOTIFICATION_TOPIC_EXCHANGE);
    }

    @Bean
    public Binding bindInternalNotificationQueueToTopicExchangeForPostComment(
            @Qualifier(BEAN_INTERNAL_NOTIFICATION_QUEUE) Queue queue,
            @Qualifier(BEAN_COMMENT_NOTIFICATION_TOPIC_EXCHANGE) TopicExchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange).with("post.#");
    }

    @Bean
    public Binding bindInternalNotificationQueueToTopicExchangeForProductComment(
            @Qualifier(BEAN_INTERNAL_NOTIFICATION_QUEUE) Queue queue,
            @Qualifier(BEAN_COMMENT_NOTIFICATION_TOPIC_EXCHANGE) TopicExchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange).with("product.*");
    }

    @Bean
    public Binding bindEmailNotificationQueueToTopicExchangeForProductComment(
            @Qualifier(BEAN_EMAIL_NOTIFICATION_QUEUE) Queue queue,
            @Qualifier(BEAN_COMMENT_NOTIFICATION_TOPIC_EXCHANGE) TopicExchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange).with("product.*.#");
    }
}