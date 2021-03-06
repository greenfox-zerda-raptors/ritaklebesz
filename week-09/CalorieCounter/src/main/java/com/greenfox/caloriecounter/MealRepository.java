package com.greenfox.caloriecounter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

/**
 * Created by Rita on 2017-01-02.
 */
public interface MealRepository extends CrudRepository<Meal, Long> {

    @Query("SELECT sum(meal.calories) from Meal meal")
    int getSumOfCalories();

    @Query("SELECT meal from Meal meal order by meal.date")
    Page<Meal> findAllOrderedByDate(Pageable pageable);

    Page<Meal> findByTypeAndDateBetweenOrderByDateDesc(String type, LocalDate startdate, LocalDate enddate, Pageable pageable);

    Page<Meal> findAllByDateBetweenOrderByDateDesc(LocalDate startdate, LocalDate enddate, Pageable pageable);
}
