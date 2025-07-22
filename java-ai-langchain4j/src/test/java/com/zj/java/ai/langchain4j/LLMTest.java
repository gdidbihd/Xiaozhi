package com.zj.java.ai.langchain4j;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {

    @Test
    public void testGPTDemo() {
        //初始化模型
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo") //设置模型apiKey
                .modelName("gpt-4o-mini") //设置模型名称
                .build();
        //向模型提问
        String answer = model.chat("你好，你叫什么名字，你是由谁创造的？");
        //输出结果
        System.out.println(answer);
    }

    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Test
    public void testSpringBoot(){
        String answer = openAiChatModel.chat("你好，你叫什么名字，你是由谁创造的？");
        System.out.println(answer);

    }
}
