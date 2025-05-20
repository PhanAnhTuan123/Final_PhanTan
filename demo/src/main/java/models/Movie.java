package models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie implements Serializable {

    @Id
    @Column(name = "movie_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private String id;

    private String title;

    private String genre;

    @Column(name = "release_year")
    private String releaseYear;

    private String director;

    private int duration;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id")
    )
    @Column(name = "actor", nullable = false)
    private Set<String> actors = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    @ToString.Exclude
    private Set<Show> shows = new HashSet<>();

}
