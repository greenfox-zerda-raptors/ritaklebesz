package com.greenfox.rita.reddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rita on 2017-01-04.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }
}
