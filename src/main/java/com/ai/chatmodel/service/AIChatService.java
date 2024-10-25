package com.ai.chatmodel.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AIChatService {
    private final OpenAiChatModel chatModel;

    public AIChatService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getBooks(String category, String year) {
        PromptTemplate promptTemplate = createBookPromptTemplate(category, year);
        ChatResponse chatResponse = chatModel.call(
                new Prompt(promptTemplate.createMessage())
        );
        return chatResponse.
                getResult()
                .getOutput()
                .getContent();
    }

    private PromptTemplate createBookPromptTemplate(String category, String year) {
        return new PromptTemplate(
                """
                               Please provide me best 5 books for the given {category} and the year {year}.
                               Please do provide a summary of each book as well, the information should be
                               limited and not much in depth, Please provide the details in the JSON format
                               containing this information : category, year, review, author, summary
                        """,
                Map.of(
                        "category", category,
                        "year", year
                )
        );
    }
}
