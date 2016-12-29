package com.greenfox.repository;

import com.greenfox.Subject;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2016-12-29.
 */
public interface ClassRepository extends CrudRepository<Subject, String> {

}
