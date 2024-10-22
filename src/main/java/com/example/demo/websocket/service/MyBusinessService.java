package com.example.demo.websocket.service;
import org.springframework.stereotype.Service;

@Service
public class MyBusinessService {

    public String processMessage(String message) {
        // 处理业务逻辑
        return "业务处理结果：" + message;
    }
}
