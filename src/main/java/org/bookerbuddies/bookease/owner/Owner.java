package org.bookerbuddies.bookease.owner;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.booking.Booking;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.feedback.FeedBack;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.payment.Payment;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Owner {
    private String name;
    @Id
    private Integer id;
    private String email;
    private String password;

    @OneToOne
    private Account account;

    @OneToMany
    List<MeetingRoom> meetingRooms = new ArrayList<>();
    @OneToMany
    List<Client> clients = new ArrayList<>();
    @OneToMany
    List<Booking> bookings= new ArrayList<>();

    @OneToMany
    List<Payment> viewPayments=new ArrayList<>();


}
