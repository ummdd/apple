package com.umid.apple.controller;

import com.umid.apple.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World")
            String name,
            Map<String,Object> map
    ) {
        map.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(
         Map<String,Object> model
    ){

        Object messageList = messageRepo.findAll();
        model.put("messageList",messageList);
        return "main";
    }


    @PostMapping
    public String main(){


        return "";
    }
}