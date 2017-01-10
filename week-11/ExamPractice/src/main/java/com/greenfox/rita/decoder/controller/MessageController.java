package com.greenfox.rita.decoder.controller;

import com.greenfox.rita.decoder.domain.Message;
import com.greenfox.rita.decoder.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rita on 2017-01-10.
 */
@Controller
@RequestMapping("/caesarcipher")
public class MessageController {

    MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping(value = {"", "/", "/index"})
    public String index(Model model) {
        model.addAttribute("message", new Message());
        return "index";
    }

    @PostMapping(value = "/")
    public String addMessage(@ModelAttribute Message message) {
        service.saveNewMessage(message);
        return "redirect:/caesarcipher/" + message.getId();
    }

    @GetMapping(value = "/{id}")
    public String process(Model model, @PathVariable long id) {
        model.addAttribute("message", service.processMessage(service.getMessage(id)));
        return "message";
    }
}
