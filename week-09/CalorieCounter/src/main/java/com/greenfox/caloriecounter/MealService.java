package com.greenfox.caloriecounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rita on 2017-01-02.
 */
@Service
public class MealService {
    @Autowired
    MealRepository mealRepository;

    public MealService() {
    }

    public List<Meal> getAllMeals() {
        return (List<Meal>) mealRepository.findAll();
    }

    public void deleteMeal(Meal meal) {
        mealRepository.delete(meal);
    }

    public void addMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public long getMealCount() {
        return mealRepository.count();
    }
}
