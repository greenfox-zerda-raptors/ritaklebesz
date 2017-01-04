package com.greenfox.rita.reddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rita on 2017-01-04.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/posts/";
    }
}
