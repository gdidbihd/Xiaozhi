package com.zj.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "calculatorTools"

)
public interface SeparateChatAssistant {
//    @SystemMessage("你是一个东北人，请用东北话与我聊天")
    @SystemMessage(fromResource = "my-prompt-template.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @SystemMessage(fromResource = "my-prompt-template2.txt")
    String chat2(@MemoryId int memoryId, @UserMessage String userMessage,
                 @V("username") String username, @V("age") int age);
}
