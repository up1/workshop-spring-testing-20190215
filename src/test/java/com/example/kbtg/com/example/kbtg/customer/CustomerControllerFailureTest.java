package com.example.kbtg.com.example.kbtg.customer;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerFailureTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_return_code_404_with_customer_not_found() {
        // Call API
        ResponseError response
                = restTemplate.getForObject("/customers", ResponseError.class);

        // Assert
        assertEquals(404, response.getCode());
        assertEquals("Customer not found", response.getMessage());
    }

}