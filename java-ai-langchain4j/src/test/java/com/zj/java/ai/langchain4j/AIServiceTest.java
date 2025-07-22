package com.zj.java.ai.langchain4j;

import com.zj.java.ai.langchain4j.assistant.Assistant;
import com.zj.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.zj.java.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIServiceTest {
    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Autowired
    private Assistant assistant;

    @Test
    public void testAssistant() {
        String result = assistant.chat("请写一个java程序，打印1到1000的数字");
        System.out.println(result);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testMemoryChatAssistant() {
        String result = memoryChatAssistant.chat("我是张军");
        System.out.println(result);
        String result1 = memoryChatAssistant.chat("我是谁");
        System.out.println(result1);
    }

    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testSeparateChatAssistant() {
        String result = separateChatAssistant.chat(1,"我是张军");
        System.out.println(result);
        String result1 = separateChatAssistant.chat(1,"我是谁");
        System.out.println(result1);

        String result2 = separateChatAssistant.chat(2,"我是谁");
        System.out.println(result2);
    }

    @Test
    public void testPrompt() {
//        String result = separateChatAssistant.chat(3,"我是张军");
//        System.out.println(result);
//        String result1 = separateChatAssistant.chat(3,"我是谁");
//        System.out.println(result1);

        String result1 = separateChatAssistant.chat(3,"今天几号");
        System.out.println(result1);

    }


    @Test
    public void testV() {
        // 从数据库中获取用户信息
        String username = "张军";
        int age = 18;
        String result1 = separateChatAssistant.chat2(5,"今天几号",username, age);
        System.out.println(result1);

    }
}
