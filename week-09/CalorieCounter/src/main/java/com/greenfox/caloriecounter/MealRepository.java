package com.greenfox.caloriecounter;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2017-01-02.
 */
public interface MealRepository extends CrudRepository<Meal, Long> {

    @Query("SELECT sum(meal.calories) from Meal meal")
    int getSumOfCalories();

    @Query("SELECT meal from Meal meal order by meal.date")
    Iterable<Meal> findAllOrderedByDate();
}
