package com.ai.chatmodel.controller;

import com.ai.chatmodel.service.AIChatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping(value = "/explain-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String explainImage(
            @RequestPart("image") MultipartFile image) {
        return chatService.describeImage(image);
    }

}
