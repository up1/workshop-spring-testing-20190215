package com.example.kbtg.com.example.kbtg.customer;

import java.util.List;

public class ResponseCustomer {
    private int code;
    private String message;

    private List<Customer> customer;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
