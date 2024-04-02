package org.bookerbuddies.bookease.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentControlAdvice {

    @ExceptionHandler(value = {PaymentInsufficientBalance.class})
    public ResponseEntity<String> accountExceptionHandler(PaymentInsufficientBalance e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
