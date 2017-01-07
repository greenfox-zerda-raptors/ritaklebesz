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
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                        @RequestParam(name = "limit", defaultValue = "15") Integer limit) {
        model.addAttribute("meals", mealService.getAllMeals(page, limit));
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

    @RequestMapping(value = "/toEdit", method = RequestMethod.POST)
    public String goToEdit(@RequestParam("toEdit") long id) {
        String path = "redirect:edit/" + id;
        return path;
    }

    @GetMapping(value = "/edit/{id}")
    public String editMeal(Model model, @PathVariable String id) {
        Long idNumber = Long.parseLong(id.trim());
        model.addAttribute("meal", mealService.getMeal(idNumber));
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String editMeal(@PathVariable int id,
                           @RequestParam("date") String date,
                           @RequestParam("type") String type,
                           @RequestParam("description") String description,
                           @RequestParam("calories") int calories) {
        mealService.updateMeal(id, date, type, description, calories);
        return "redirect:/caloriecounter/index";
    }
}

