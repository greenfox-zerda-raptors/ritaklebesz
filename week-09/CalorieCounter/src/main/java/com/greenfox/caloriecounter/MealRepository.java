package com.greenfox.caloriecounter;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2017-01-02.
 */
public interface MealRepository extends CrudRepository<Meal, Long> {
}
