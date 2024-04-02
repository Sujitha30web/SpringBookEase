package org.bookerbuddies.bookease.payment;

import org.bookerbuddies.bookease.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment>  findByAccountTypeAndSenderId (String  typeOfPerson, Integer accountId);

}
