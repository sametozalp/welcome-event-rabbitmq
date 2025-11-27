package com.ozalp.consumer;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleUserCreatedEvent(UserCreatedEvent event) {

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------------------");
        System.out.println("ASENKRON TÜKETİCİ DEVREDE:");
        System.out.println("Kime: " + event.getEmail());
        System.out.println("Mesaj: Merhaba " + event.getUsername() + ", aramıza hoş geldin!");
        System.out.println("------------------------------------------");

        // if throw this error, it does not try again
        //throw new AmqpRejectAndDontRequeueException("");

    }
}