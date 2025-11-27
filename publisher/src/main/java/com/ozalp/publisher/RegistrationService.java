package com.ozalp.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final RabbitTemplate rabbitTemplate;

    public RegistrationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void registerUser(String username, String email) {

        UserCreatedEvent event = new UserCreatedEvent(username, email);

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                event
        );

        System.out.println("LOG: RabbitMQ'ya mesaj gönderildi.");
    }
}