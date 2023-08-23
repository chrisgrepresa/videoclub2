package com.blockbuster.videoclub.service;

import com.blockbuster.videoclub.dao.MovieRental;
import com.blockbuster.videoclub.repository.MovieRentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieRentalService {

    private final MovieRentalRepository movieRentalRepository;
    public MovieRentalService(MovieRentalRepository movieRentalRepository){
        this.movieRentalRepository = movieRentalRepository;
    }

    public List<MovieRental> findAllMovieRental(){
        return movieRentalRepository.findAll();
    }
}
