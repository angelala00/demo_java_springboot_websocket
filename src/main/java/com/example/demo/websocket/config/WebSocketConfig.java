package com.example.demo.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.websocket.handler.MyWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private MyWebSocketHandler myWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler, "/websocket").setAllowedOrigins("*");
    }
}
