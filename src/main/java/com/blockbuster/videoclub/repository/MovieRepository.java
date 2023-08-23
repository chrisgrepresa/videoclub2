package com.blockbuster.videoclub.repository;

import com.blockbuster.videoclub.dao.Movie;
import com.blockbuster.videoclub.dto.MovieCustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query("""
            SELECT new com.blockbuster.videoclub.dto.MovieCustomerDTO
            (m.movieId, m.director, m.genre, m.releaseYear, m.title, c.firstName, c.lastName, mr.dueReturnDate, mr.isReturned)
            FROM Movie m
            JOIN MovieRental mr ON m.movieId = mr.movie.movieId
            JOIN Customer c ON mr.customer.customerId = c.customerId
            WHERE m.movieId = :movieId
            """)
    List<MovieCustomerDTO> findMovieAndRenterCustomer(Integer movieId);

}
