package com.example.kbtg.com.example.kbtg.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest3 {

    @Mock
    private CustomerRepository repository;

    @Test
    public void success_with_get_all_customer_2() {
        // Initial data
        when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new Customer("Name 1", "Last 1"),
                        new Customer("Name 2", "Last 2")
                )
        );
        CustomerController controller
                = new CustomerController(repository);
        ResponseCustomer response = controller.inquiryCustomers();

        // Assert
        assertEquals(200, response.getCode());
        assertEquals(2, response.getCustomer().size());
    }

}