package com.umid.apple.controller;

import com.umid.apple.db.MessageDatabase;
import com.umid.apple.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping
    public String greeting(
             Map<String,Object> map
    ) {
         return "greeting";
    }

    @GetMapping("/main")
    public String main(
         Map<String,Object> model
    ){
        Object messageList = messageRepo.findAll();
        model.put("messageList",messageList);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            Map<String,Object> model,
            @RequestParam String text,
            @RequestParam String tag
    ){
        MessageDatabase messageDatabase = new MessageDatabase(
                text,tag
        );
        messageRepo.save(messageDatabase);

        Object messageList = messageRepo.findAll();
        model.put("messageList",messageList);

        return "main";
    }

    @PostMapping("/filter")
    public String filter(
            Map<String,Object> model,
            @RequestParam String text
    ){

        List<MessageDatabase> messageDatabases = messageRepo.findByText(text);
        model.put("messageList",messageDatabases);

        return "main";
    }


}