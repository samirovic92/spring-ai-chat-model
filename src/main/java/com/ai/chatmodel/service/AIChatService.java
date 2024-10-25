package com.ai.chatmodel.service;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.model.Media;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

import static org.springframework.ai.openai.api.OpenAiApi.*;

@Service
public class AIChatService {
    private final OpenAiChatModel chatModel;

    public AIChatService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getBooks(String category, String year) {
        PromptTemplate promptTemplate = createBookPromptTemplate(category, year);

        return chatModel.call(promptTemplate.createMessage());
    }

    public String describeImage(MultipartFile image) {
        var media = new Media(
                MimeTypeUtils.parseMimeType(image.getContentType()),
                image.getResource()
        );
        var userMessage = new UserMessage(
                "Explain what do you see on this picture",
                media
        );
        return chatModel.call(userMessage);
    }

    private PromptTemplate createBookPromptTemplate(String category, String year) {
        return new PromptTemplate(
                """
                               Please provide me best 5 books for the given {category} and the year {year}.
                               Please do provide a summary of each book as well, the information should be
                               limited and not much in depth, Please provide the details in the JSON format
                               containing this information : category, name of the book, year, review, author, summary
                        """,
                Map.of(
                        "category", category,
                        "year", year
                )
        );
    }
}
