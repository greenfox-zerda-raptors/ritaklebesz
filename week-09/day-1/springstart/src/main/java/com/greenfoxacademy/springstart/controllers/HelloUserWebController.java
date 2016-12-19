package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Rita on 2016-12-19.
 */
@Controller
public class HelloUserWebController {
    AtomicLong idGenerator = new AtomicLong(1);

    @RequestMapping("/web/greeting")
    public String greeting(Model model, @RequestParam("name") String name) {
        model.addAttribute("name", name);
        model.addAttribute("count", idGenerator.getAndIncrement());
        return "greetUserCounter";
    }
}
