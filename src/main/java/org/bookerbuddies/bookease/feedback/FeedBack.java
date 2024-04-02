package org.bookerbuddies.bookease.feedback;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBack {
    @Id
    private  Integer feedbackId;
    private String comment;
    private Double ratings;
    private LocalDateTime submissionDate;
}
