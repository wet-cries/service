package org.example.controllers;

import org.example.domain.Message;
import org.example.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DeleteController {
    @Autowired
    private MessageRepo messageRepo;

    @PostMapping("/delete")
    public String deleteByTags(@RequestParam Long id, Map<String, Object> model) {
        if (messageRepo.existsById(id))
            messageRepo.deleteById(id);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }
}
