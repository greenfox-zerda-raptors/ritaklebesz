package com.greenfoxacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Rita on 2016-12-20.
 */
@Controller
public class HelloController {

    @RequestMapping("/helloWorld")
    public String greet(Model model, @RequestParam(defaultValue = "Thymeleaf", name = "name", required = false) String name) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
