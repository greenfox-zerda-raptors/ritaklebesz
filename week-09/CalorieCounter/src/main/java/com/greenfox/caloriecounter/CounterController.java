package com.greenfox.caloriecounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rita on 2016-12-30.
 */
@Controller
@RequestMapping("/caloriecounter")
public class CounterController {

    @Autowired
    private MealService mealService;
    @Autowired
    private MealRepository mealRepository;

    @RequestMapping(value = {"/index", "/"})
    public String index() {
        return "index";
    }

    @GetMapping(value = "/add")
    public String addNewMeal(Model model) {
        model.addAttribute("meal", new Meal());
        return "add";
    }

    @PostMapping(value = "/add")
    public String submitNewMeal(@ModelAttribute Meal meal) {
//        mealService.addMeal(meal);
        mealRepository.save(meal);
        return "redirect:index";
    }
}

