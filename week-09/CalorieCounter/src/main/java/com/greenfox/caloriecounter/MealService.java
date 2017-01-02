package com.greenfox.caloriecounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rita on 2017-01-02.
 */
@Service
public class MealService {
    List<Meal> listOfMeals;
    @Autowired
    MealRepository mealRepository;

    public MealService() {
    }

    public List<Meal> getMeals() {
        return listOfMeals;
    }

    public void addMeal(Meal meal) {
        if (meal.getId() == 0) {
            meal.setId((long) listOfMeals.size());
        }
        listOfMeals.add(meal);
    }

    public void updateList() {
        listOfMeals = (List<Meal>) mealRepository.findAll();
    }

    public int getMealCount() {
        return listOfMeals.size();
    }
}
