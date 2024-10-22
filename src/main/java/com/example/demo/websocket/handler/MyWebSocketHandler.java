package com.example.demo.websocket.handler;

import com.example.demo.websocket.service.MyBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.stereotype.Component;

// 假设你有一个业务逻辑服务 MyBusinessService
@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private MyBusinessService myBusinessService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("连接已建立：" + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("收到消息：" + message.getPayload());

        // 调用业务逻辑
        String responseMessage = myBusinessService.processMessage(message.getPayload());

        // 发送响应
        TextMessage response = new TextMessage("服务端响应：" + responseMessage);
        session.sendMessage(response);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("连接已关闭：" + session.getId());
    }
}
