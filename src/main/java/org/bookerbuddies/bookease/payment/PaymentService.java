package org.bookerbuddies.bookease.payment;

import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.payment.exception.PaymentInsufficientBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface PaymentService {

    Double transaction(Integer senderId, Integer receiverId, Double amount) throws PaymentInsufficientBalance;

    List<Payment> payments(String typeOfPerson, Integer id );


    Double paymentsCancellation(LocalDate bookingDate, Client client);
}