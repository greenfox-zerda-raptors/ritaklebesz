package com.greenfox.repository;

import com.greenfox.Grade;
import com.greenfox.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Rita on 2016-12-29.
 */
public interface GradeRepository extends CrudRepository<Grade, Long> {
    @Query("SELECT grade FROM Grade grade WHERE grade.classCode=:subject")
    Iterable<Grade> findBySubjectName(@Param("subject") Subject subject);

    @Query("SELECT DISTINCT grade.classCode FROM Grade grade")
    Iterable<Subject> findAllSubjects();
}
