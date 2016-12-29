package com.greenfox;

import com.greenfox.repository.CustomerRepository;
import com.greenfox.repository.OrderRepository;
import com.greenfox.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Workshop03Application.class)
@WebAppConfiguration
public class Workshop03ApplicationTests {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @Test
    @Sql({"/clear-tables.sql", "/populate-tables.sql"})
    @Transactional
    public void shouldReturnManyPhonesForCustomer() {
        Customer myself = customerRepository.findByName("Marcio");
        assertThat(myself.getPhoneNumbers().size(), is(2));
    }

    @Test
    @Sql({"/clear-tables.sql", "/populate-tables.sql"})
    @Transactional
    public void shouldDeleteOrder() {
        Customer jonas = customerRepository.findByName("Jonas");
        Order jonasOrder = orderRepository.findByCustomer(jonas);
        orderRepository.delete(jonasOrder);  //deletes the one order of Jonas; so there should not be any left

        List<Order> orders = (List<Order>) orderRepository.findAll();
        assertThat(orders.size(), is(0));
    }

    @Test
    @Sql({"/clear-tables.sql", "/populate-tables.sql"})
    @Transactional
    public void shouldCreateOrder() {
        
        Customer myself = customerRepository.findByName("Marcio");
        Order order = Order.builder()
                .customer(myself)
                .createdAt(new Date())
                .build();

        Product mazdaCar = productRepository.findByName("Mazda 3");
        Product myPopCorn = productRepository.findByName("Pop Corn");

        Item mazda = Item.builder()
                .product(mazdaCar)
                .order(order)
                .quantity(3)
                .build();

        Item popcorn = Item.builder()
                .product(myPopCorn)
                .order(order)
                .quantity(7)
                .build();

        List<Item> items = new ArrayList<Item>() {{
            add(mazda);
            add(popcorn);
        }};

        order.setItems(items);
        orderRepository.save(order);

        List<Order> orders = (List<Order>) orderRepository.findAll();
        Order foundOrder = orders.get(1);

        assertThat(orders.size(), is(2));
        assertThat(foundOrder.getItems().size(), is(2));
        assertThat(foundOrder.getItems().get(0).getProduct(), is(mazdaCar));
        assertThat(foundOrder.getItems().get(1).getProduct(), is(myPopCorn));
    }
}
