package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rita on 2016-12-19.
 */
@RestController
public class HelloRESTController {

    @RequestMapping(value = "/greeting")
    public Greeting greeting(@RequestParam("name") String content) {
        Greeting result = new Greeting(1, "Hello, " + content + "!");
        return result;
    }
}
