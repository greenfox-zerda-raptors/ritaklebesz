package com.greenfox.caloriecounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rita on 2016-12-30.
 */
@Controller
@RequestMapping("/caloriecounter")
public class CounterController {


    private MealService mealService;

    @Autowired
    public CounterController(MealService mealService) {
        this.mealService = mealService;
    }

    @RequestMapping(value = {"/index", "/", ""})
    public String index(Model model) {
        model.addAttribute("meals", mealService.getAllMeals());
        model.addAttribute("mealCount", mealService.getMealCount());
        model.addAttribute("calories", mealService.getSumOfAllCalories());
        return "index";
    }

    @GetMapping(value = "/add")
    public String addNewMeal(Model model) {
        model.addAttribute("meal", new Meal());
        return "add";
    }

    @PostMapping(value = "/add")
    public String submitNewMeal(@ModelAttribute Meal meal) {
        mealService.addMeal(meal);
        return "redirect:index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteMeal(@RequestParam("delete") long id) {
        mealService.deleteMeal(id);
        return "redirect:index";
    }
}

