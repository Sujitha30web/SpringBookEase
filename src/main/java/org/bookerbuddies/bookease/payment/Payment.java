package org.bookerbuddies.bookease.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookerbuddies.bookease.booking.Booking;






@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentId;
    private Integer senderId;
    private Integer receiverId;
    private Double amount;
    private String accountType;
    private Boolean status;

    public Payment(Integer paymentId, Integer senderId, Integer receiverId, Double amount, Boolean status) {
        this.paymentId = paymentId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.status = status;
    }


    public Payment(Integer paymentId, Integer senderId, Integer receiverId, Double amount,  Boolean status,String accountType) {
        this.paymentId = paymentId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.status = status;
        this.accountType = accountType;
    }
}
