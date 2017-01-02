package com.greenfox.caloriecounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        return (List<Meal>) mealRepository.findAllOrderedByDate();
    }

    public void deleteMeal(long id) {
        mealRepository.delete(id);
    }

    public void addMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public void updateMeal(long id, String newDate, String newType, String newDescription, int newCalories) {
        Meal meal = mealRepository.findOne(id);
        meal.setDate(LocalDate.parse(newDate));
        meal.setType(newType);
        meal.setDescription(newDescription);
        meal.setCalories(newCalories);
        mealRepository.save(meal);
    }

    public Meal getMeal(long id) {
        return mealRepository.findOne(id);
    }

    public long getMealCount() {
        return mealRepository.count();
    }

    public int getSumOfAllCalories() {
        return mealRepository.getSumOfCalories();
    }
}
