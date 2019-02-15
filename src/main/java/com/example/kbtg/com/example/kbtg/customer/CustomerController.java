package com.example.kbtg.com.example.kbtg.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    private CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    public ResponseCustomer inquiryCustomers() {
        // Get data from repository
        List<Customer> customers
                = (List<Customer>) repository.findAll();
        if(customers.isEmpty()) {
            throw new CustomerNotFoundException();
        }

        // Make response
        ResponseCustomer responseCustomer = new ResponseCustomer();
        responseCustomer.setCode(200);
        responseCustomer.setMessage("OK");
        responseCustomer.setCustomer(customers);
        return responseCustomer;

    }

    private ResponseCustomer generateSuccessResult() {
        ResponseCustomer responseCustomer = new ResponseCustomer();
        responseCustomer.setCode(200);
        responseCustomer.setMessage("OK");
        responseCustomer.setCustomer(Arrays.asList(
                new Customer("Name 1", "Last 1"),
                new Customer("Name 2", "Last 2"),
                new Customer("Name 3", "Last 3")
        ));
        return responseCustomer;
    }

}
