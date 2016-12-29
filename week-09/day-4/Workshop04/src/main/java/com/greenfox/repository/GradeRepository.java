package com.greenfox.repository;

import com.greenfox.Grade;
import com.greenfox.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Rita on 2016-12-29.
 */
public interface GradeRepository extends CrudRepository<Grade, Long> {
    @Query("SELECT grade.classcode FROM Grade grade")
    List<Subject> findAllSubjects();
}
