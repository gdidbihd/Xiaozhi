package com.zj.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
//        streamingChatModel = "openAiStreamingChatModel",
        chatMemoryProvider = "chatMemoryProviderXiaozhi",
        tools = "appointmentTools",
        contentRetriever = "contentRetrieverXiaozhiPincone"
)
public interface XiaozhiAgent {
    @SystemMessage(fromResource = "xiaozhi-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);
//    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
