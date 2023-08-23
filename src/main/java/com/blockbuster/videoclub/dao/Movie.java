package com.blockbuster.videoclub.dao;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="movie")
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "movie_id")
    private Integer movieId;

    @Column (name = "director")
    private String director;

    @Column (name = "duration_minutes")
    private Integer durationMinutes;

    @Column (name = "genre")
    private String genre;

    @Temporal(TemporalType.DATE)
    @Column (name = "release_year")
    private Date releaseYear;

    @Column (name = "title")
    private String title;

    @OneToMany(mappedBy= "movie")
    private List<MovieRental> movieRentals;
}
