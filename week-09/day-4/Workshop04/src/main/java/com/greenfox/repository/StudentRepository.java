package com.greenfox.repository;

import com.greenfox.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2016-12-29.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
}
