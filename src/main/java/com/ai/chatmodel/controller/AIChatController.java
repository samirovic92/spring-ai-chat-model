package com.ai.chatmodel.controller;

import com.ai.chatmodel.service.AIChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AIChatController {

    private AIChatService chatService;

    public AIChatController(AIChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/books")
    public String getBooks(@RequestParam String category,
                           @RequestParam String year) {
        return chatService.getBooks(category, year);
    }

}
