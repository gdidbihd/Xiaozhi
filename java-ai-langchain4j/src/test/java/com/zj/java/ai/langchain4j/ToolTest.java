package com.zj.java.ai.langchain4j;

import com.zj.java.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToolTest {
    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculator(){
        String result1 = separateChatAssistant.chat(21,"计算4646464的平方根");
        System.out.println(result1);
    }
}
