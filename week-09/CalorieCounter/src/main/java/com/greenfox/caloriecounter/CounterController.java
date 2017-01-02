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


    private MealService mealService;
    @Autowired
    private MealRepository mealRepository;

    @Autowired
    public CounterController(MealService mealService) {
        this.mealService = mealService;
    }

    @RequestMapping(value = {"/index", "/"})
    public String index(Model model) {
        mealService.updateList();
        model.addAttribute("meals", mealService.getMeals());
        return "index";
    }

    @GetMapping(value = "/add")
    public String addNewMeal(Model model) {
        model.addAttribute("meal", new Meal());
        return "add";
    }

    @PostMapping(value = "/add")
    public String submitNewMeal(@ModelAttribute Meal meal) {
        mealRepository.save(meal);
        return "redirect:index";
    }
}

