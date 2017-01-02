package com.greenfox.caloriecounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rita on 2016-12-30.
 */
@Controller
@RequestMapping("/caloriecounter")
public class CounterController {

    @Autowired
    private MealService mealService;

    @RequestMapping(value = {"/index", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/add"})
    public String addOrEdit() {
        return "add";
    }
}

