package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Rita on 2016-12-19.
 */
@RestController
public class HelloRESTController {
    AtomicLong idGenerator = new AtomicLong(1);

    @RequestMapping(value = "/greeting")
    public Greeting greeting(@RequestParam("name") String content) {
        Greeting result = new Greeting(idGenerator.getAndIncrement(), "Hello, " + content + "!");
        return result;
    }
}
