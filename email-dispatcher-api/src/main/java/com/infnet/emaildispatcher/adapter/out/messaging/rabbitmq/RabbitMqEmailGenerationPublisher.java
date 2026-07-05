package com.infnet.emaildispatcher.adapter.out.messaging.rabbitmq;

import com.infnet.emaildispatcher.application.domain.model.email.EmailGeneration;
import com.infnet.emaildispatcher.application.port.out.email.IEmailGenerationPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqEmailGenerationPublisher implements IEmailGenerationPublisher {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing-key.email-generation}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqEmailGenerationPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publish(EmailGeneration emailGeneration) {
        rabbitTemplate.convertAndSend(exchange, routingKey, emailGeneration);
    }
}
