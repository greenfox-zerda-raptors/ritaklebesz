package com.greenfox.repository;

import com.greenfox.Customer;
import com.greenfox.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2016-12-29.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findByCustomer(Customer customer);
}
