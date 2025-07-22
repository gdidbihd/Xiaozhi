package com.zj.java.ai.langchain4j.store;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ChatMessageCleaner {

//    private static final Pattern THINK_PATTERN = Pattern.compile("(?s)<think>.*?</think>");
    private static final Pattern THINK_PATTERN = Pattern.compile("(?s).*?</think>");

    public static List<ChatMessage> removeThinkBlocks(List<ChatMessage> messages) {
        return messages.stream()
            .map(ChatMessageCleaner::cleanMessage)
            .collect(Collectors.toList());
    }

    private static ChatMessage cleanMessage(ChatMessage message) {
        if (message instanceof AiMessage) {
            AiMessage aiMessage = (AiMessage) message;
            String cleaned = removeThink(aiMessage.text());
            return new AiMessage(cleaned);
        } else {
            // Other message types are passed through unchanged
            return message;
        }
    }

    public static String removeThink(String text) {
        if (text == null) return null;
        return THINK_PATTERN.matcher(text).replaceAll("");
    }
}
