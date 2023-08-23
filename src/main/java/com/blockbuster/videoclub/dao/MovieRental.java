package com.blockbuster.videoclub.dao;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name= "movie_rentals")
public class MovieRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "rented_on")
    private Date rentedOn;

    @Column(name = "due_return_date")
    private Date dueReturnDate;

    @Column(name = "is_returned")
    private Boolean isReturned;

}
