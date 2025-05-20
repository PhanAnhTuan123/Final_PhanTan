package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "shows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show implements Serializable {

    @Id
    @Column(name = "show_id")
    @ToString.Include
    private String id;

    @Column(name = "show_date_time")
    private LocalDateTime showDateTime;

    @Column(name = "hall_name")
    private String hallName;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @ToString.Exclude
    private Movie movie;

    @OneToMany(mappedBy = "show")
    @ToString.Exclude
    private Set<Ticket> tickets;
}
