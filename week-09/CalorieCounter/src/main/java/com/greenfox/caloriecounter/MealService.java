package com.greenfox.caloriecounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by Rita on 2017-01-02.
 */
@Service
public class MealService {
    @Autowired
    MealRepository mealRepository;

    public MealService() {
    }

    public Page<Meal> getAllMeals(Integer page, Integer limit) {
        return mealRepository.findAllOrderedByDate(new PageRequest(page, limit));
    }

    public Page<Meal> getRequestedMeals(String type, String startdate, String enddate, int page, int limit) {
        if (type.equals("All")) {
            return mealRepository.findAllByDateBetweenOrderByDateDesc(LocalDate.parse(startdate), LocalDate.parse(enddate), new PageRequest(page, limit));
        }
        return mealRepository.findByTypeAndDateBetweenOrderByDateDesc(type, LocalDate.parse(startdate), LocalDate.parse(enddate), new PageRequest(page, limit));
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
