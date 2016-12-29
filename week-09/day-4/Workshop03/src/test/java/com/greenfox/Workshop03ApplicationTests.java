package com.greenfox;

import com.greenfox.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Workshop03Application.class)
@WebAppConfiguration
public class Workshop03ApplicationTests {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    @Sql({"/clear-tables.sql", "/populate-tables.sql"})
    @Transactional
    public void shouldReturnManyPhonesForCustomer() {
        Customer myself = customerRepository.findByName("Marcio");
        assertThat(myself.getPhoneNumbers().size(), is(2));
    }
}
