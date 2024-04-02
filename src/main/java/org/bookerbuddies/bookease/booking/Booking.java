package org.bookerbuddies.bookease.booking;

import jakarta.persistence.*;
import lombok.*;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.feedback.FeedBack;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.payment.Payment;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Booking {
    @Id
    private Integer id;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate bookingDate;
    private LocalDate bookedDate;
    private Boolean status;

    @OneToOne
    private Payment payment;

    @ManyToOne
    private MeetingRoom meetingRoom;


}
