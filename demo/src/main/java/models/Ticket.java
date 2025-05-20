package models;

import jakarta.persistence.*;
import lombok.*;
import models.enums.Type;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket implements Serializable {
    @Id
    @Column(name = "ticket_number")
    @EqualsAndHashCode.Include
    private String ticketNumber;

    private String seat;

    @Enumerated(EnumType.STRING)
    private Type type;

    private double price;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private  Customer customer;

    @ManyToOne
    @JoinColumn(name = "show_id")
    @ToString.Exclude
    private Show show;
}
