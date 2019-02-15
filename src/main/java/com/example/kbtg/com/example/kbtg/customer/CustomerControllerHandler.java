package com.example.kbtg.com.example.kbtg.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerControllerHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ResponseError> customerNotFound(
            CustomerNotFoundException exception
    ) {
        ResponseError responseError
                = new ResponseError(404, "Customer not found");

        return new ResponseEntity<>(
                responseError, HttpStatus.OK);
    }

}
