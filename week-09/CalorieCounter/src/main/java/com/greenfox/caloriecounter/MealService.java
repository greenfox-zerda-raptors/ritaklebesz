package com.greenfox.caloriecounter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rita on 2017-01-02.
 */
@Service
public class MealService {
    List<Meal> listOfMeals;

    public MealService() {
        listOfMeals = new ArrayList<>();
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
}
