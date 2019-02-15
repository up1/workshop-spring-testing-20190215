package com.example.kbtg.com.example.kbtg.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void get_all_customer_should_have_3_customers() {
        repository.save(new Customer("F1", "L1"));
        repository.save(new Customer("F2", "L2"));
        repository.save(new Customer("F3", "L3"));

        long count = repository.count();

        assertEquals(3, count);
    }

    @Test
    public void get_all_customer_should_have_2_customers() {
        repository.save(new Customer("F1", "L1"));
        repository.save(new Customer("F2", "L2"));

        long count = repository.count();

        assertEquals(2, count);
    }

}