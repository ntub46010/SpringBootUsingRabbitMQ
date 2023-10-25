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

    @Bean(name = BEAN_COMMENT_NOTIFICATION_FANOUT_EXCHANGE)
    public FanoutExchange commentNotificationFanoutExchange() {
        return new FanoutExchange(NAME_COMMENT_NOTIFICATION_FANOUT_EXCHANGE);
    }

    @Bean(name = BEAN_COMMENT_NOTIFICATION_DIRECT_EXCHANGE)
    public DirectExchange commentNotificationDirectExchange() {
        return new DirectExchange(NAME_COMMENT_NOTIFICATION_DIRECT_EXCHANGE);
    }

    @Bean
    public Binding bindInternalNotificationQueueToFanoutExchange(
            @Qualifier(BEAN_INTERNAL_NOTIFICATION_QUEUE) Queue queue,
            @Qualifier(BEAN_COMMENT_NOTIFICATION_FANOUT_EXCHANGE) FanoutExchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding bindEmailNotificationQueueToFanoutExchange(
            @Qualifier(BEAN_EMAIL_NOTIFICATION_QUEUE) Queue queue,
            @Qualifier(BEAN_COMMENT_NOTIFICATION_FANOUT_EXCHANGE) FanoutExchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding bindInternalNotificationQueueToDirectExchange(
            @Qualifier(BEAN_INTERNAL_NOTIFICATION_QUEUE) Queue queue,
            @Qualifier(BEAN_COMMENT_NOTIFICATION_DIRECT_EXCHANGE) DirectExchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange).with("Internal");
    }

    @Bean
    public Binding bindEmailNotificationQueueToDirectExchange(
            @Qualifier(BEAN_EMAIL_NOTIFICATION_QUEUE) Queue queue,
            @Qualifier(BEAN_COMMENT_NOTIFICATION_DIRECT_EXCHANGE) DirectExchange exchange
    ) {
        return BindingBuilder.bind(queue).to(exchange).with("Email");
    }
}
