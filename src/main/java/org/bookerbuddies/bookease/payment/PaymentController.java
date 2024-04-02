package org.bookerbuddies.bookease.payment;


import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.payment.exception.PaymentInsufficientBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PatchMapping("payment/{senderId}/{recieverId}")
    public Double makePayment(@PathVariable Integer senderId,@PathVariable Integer recieverId,@PathVariable Double amount)throws PaymentInsufficientBalance {

        Double senderBalanceAmount = paymentService.transaction(senderId, recieverId, amount);

        return senderBalanceAmount;
    }


    @GetMapping("getPayments/{type}/{id}")
    public List<Payment> getAllPlayment(@PathVariable  String type,@PathVariable Integer id){
        return paymentService.payments(type, id);
    }

    @GetMapping("cancellation")
    public Double cancellation(@PathVariable LocalDate bookingDate, Client client){

        return paymentService.paymentsCancellation(bookingDate, client);

    }





}
