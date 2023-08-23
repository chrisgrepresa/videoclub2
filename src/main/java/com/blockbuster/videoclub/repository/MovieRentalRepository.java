package com.blockbuster.videoclub.repository;

import com.blockbuster.videoclub.dao.MovieRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRentalRepository extends JpaRepository<MovieRental,Integer> {
}
