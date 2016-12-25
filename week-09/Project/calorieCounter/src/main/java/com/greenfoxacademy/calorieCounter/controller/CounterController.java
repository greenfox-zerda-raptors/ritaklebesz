package com.greenfoxacademy.calorieCounter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rita on 2016-12-23.
 */

@Controller
@RequestMapping("/caloriecounter")
public class CounterController {

    @RequestMapping(value = {"/index", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/add"})
    public String addOrEdit() {
        return "add";
    }
}
