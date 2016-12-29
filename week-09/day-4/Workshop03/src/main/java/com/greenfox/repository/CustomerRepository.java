package com.greenfox.repository;

import com.greenfox.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2016-12-29.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByName(String name);
}
