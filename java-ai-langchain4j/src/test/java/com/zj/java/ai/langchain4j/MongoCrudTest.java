package com.zj.java.ai.langchain4j;

import com.zj.java.ai.langchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
public class MongoCrudTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testInsert() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("shohfo");
        mongoTemplate.insert(chatMessages);
    }
}
