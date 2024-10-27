package com.ai.chatmodel.service;

import org.springframework.ai.chat.model.ChatResponse;

public class AIUtils {

    public static String getContentFrom(ChatResponse response) {
        return response.getResult()
                .getOutput()
                .getContent();
    }
}
