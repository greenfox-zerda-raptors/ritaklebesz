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

    @GetMapping(value = {"/index", "/", ""})
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                        @RequestParam(name = "limit", defaultValue = "15") Integer limit,
                        @RequestParam(name = "startdate", defaultValue = "1900-01-01") String startdate,
                        @RequestParam(name = "enddate", defaultValue = "2100-01-01") String enddate,
                        @RequestParam(name = "type", defaultValue = "All") String type) {
        model.addAttribute("meals", mealService.getRequestedMeals(type, startdate, enddate, page, limit));
        model.addAttribute("mealCount", mealService.getMealCount());
        model.addAttribute("calories", mealService.getSumOfAllCalories());
        model.addAttribute("queryRequest", new QueryRequest());
        return "index";
    }

    @PostMapping(value = "/index")
    public String index(@ModelAttribute QueryRequest queryRequest) {
        return queryRequest.getPath();
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

    @RequestMapping(value = "/delete/{id}")
    public String deleteMeal(@PathVariable long id) {
        mealService.deleteMeal(id);
        return "redirect:/caloriecounter/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String editMeal(Model model, @PathVariable long id) {
        model.addAttribute("meal", mealService.getMeal(id));
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String editMeal(@PathVariable long id,
                           @RequestParam("date") String date,
                           @RequestParam("type") String type,
                           @RequestParam("description") String description,
                           @RequestParam("calories") int calories) {
        mealService.updateMeal(id, date, type, description, calories);
        return "redirect:/caloriecounter/index";
    }
}

