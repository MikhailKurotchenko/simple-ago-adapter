package com.example.simpleagoadapter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "calls")
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "app_pkid")
    private Long appPkId;

    @Column(name = "client_id")
    private Long asrClientId;

    private String msisdn;

    @Column(name = "notification_type")
    private String notificationType;

    @Column(name = "client_type")
    private String juridical;

    @Column(name = "status_id")
    @Enumerated(EnumType.STRING)
    private Status status;

    private String account;

    private Double debt;

    @Column(name = "payment_date")
    private Calendar paymentDate;

    @Column(name = "termination_date")
    private Calendar terminationDate;

    private String reason;

    @PrePersist
    private void onInsert() {
        status = Status.IN_PROGRESS;
    }
}
