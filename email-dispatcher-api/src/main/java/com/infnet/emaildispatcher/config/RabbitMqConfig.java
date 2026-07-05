package com.infnet.emaildispatcher.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.queue.email-generation}")
    private String queue;

    @Value("${rabbitmq.routing-key.email-generation}")
    private String routingKey;

    @Bean
    public DirectExchange emailExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue emailGenerationQueue() {
        return QueueBuilder.durable(queue).build();
    }

    @Bean
    public Binding emailGenerationBinding(Queue emailGenerationQueue, DirectExchange emailExchange) {
        return BindingBuilder.bind(emailGenerationQueue).to(emailExchange).with(routingKey);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
