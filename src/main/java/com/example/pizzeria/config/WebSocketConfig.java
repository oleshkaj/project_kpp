package com.example.pizzeria.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
// Налаштування підтримки WebSocket з використанням STOMP (Streaming Text Oriented Messaging Protocol)
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer
{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) // реєстрація STOMP точок підключення, через які клієнти можуть підключатися до серверу WebSocket
    {
        registry.addEndpoint("/websocket").setAllowedOrigins("http://localhost:5173/",
                "https://localhost:5173/", "http://127.0.0.1:5500/").withSockJS(); // Вказує дозволені джерела для підключень (клієнтські адреси). SockJS як механізм для підтримки WebSocket, якщо WebSocket не підтримується на стороні клієнта
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry)
    {
        registry.enableSimpleBroker("/topic"); // сервер може відправляти повідомлення клієнтам на шляхи, що починаються з /topic
        registry.setApplicationDestinationPrefixes("/app"); // повідомлення, які надсилаються клієнтами на шляхи, що починаються з /app, обробляються сервером
    }
}