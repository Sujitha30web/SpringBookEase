package org.bookerbuddies.bookease.meetingroom;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookerbuddies.bookease.booking.Booking;
import org.bookerbuddies.bookease.feedback.FeedBack;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data@AllArgsConstructor
@NoArgsConstructor
public class MeetingRoom {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer capacity;
    private Integer floorNumber;
    private String type;//enumerated datatype
    private Boolean isAvailabile;
    private String eventDescription;
    private Double costOfRoom;
    @OneToMany
    List<FeedBack> feedBacks = new ArrayList<>();
}
