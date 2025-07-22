package com.zj.java.ai.langchain4j.controller;

import com.zj.java.ai.langchain4j.assistant.XiaozhiAgent;
import com.zj.java.ai.langchain4j.bean.ChatForm;
import com.zj.java.ai.langchain4j.store.ChatMessageCleaner;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "医疗小智")
@RestController
@RequestMapping("/xiaozhi")
public class XiaozhiController {
    @Autowired
    private XiaozhiAgent xiaozhiAgent;

    @Operation(summary = "对话")
//    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    @PostMapping(value = "/chat")
    public String chat(@RequestBody ChatForm chatForm){
        String res = xiaozhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
        return ChatMessageCleaner.removeThink(res);
//        return res;
    }
}
