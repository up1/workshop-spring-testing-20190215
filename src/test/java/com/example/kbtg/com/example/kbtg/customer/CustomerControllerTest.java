package com.example.kbtg.com.example.kbtg.customer;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository repository;

    @After
    public void deleteAllCustomer() {
        repository.deleteAll();
    }

    @Test
    public void success_with_get_all_customer_2() {
        // Initial data
        repository.save(new Customer("F1", "L1"));
        repository.save(new Customer("F2", "L2"));

        // Call API
        ResponseCustomer response
                = restTemplate.getForObject("/customers", ResponseCustomer.class);

        // Assert
        assertEquals(200, response.getCode());
        assertEquals(2, response.getCustomer().size());
    }

    @Test
    public void success_with_get_all_customer() {
        // Initial data
        repository.save(new Customer("F1", "L1"));
        repository.save(new Customer("F2", "L2"));
        repository.save(new Customer("F3", "L3"));

        // Call API
        ResponseCustomer response
                = restTemplate.getForObject("/customers", ResponseCustomer.class);

        // Assert
        assertEquals(200, response.getCode());
        assertEquals(3, response.getCustomer().size());
    }

}