package com.blockbuster.videoclub.service;

import com.blockbuster.videoclub.dao.Movie;
import com.blockbuster.videoclub.dto.MovieCustomerDTO;
import com.blockbuster.videoclub.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository; // Esto se llama inyección de dependencias

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> searchAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> searchById(Integer id) {
        return movieRepository.findById(id);
    }

    public Movie saveNewMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie modifyMovie(Integer id, Movie movie) {
        Optional<Movie> movieToSearch = movieRepository.findById(id);
        if (movieToSearch.isPresent()) {
            movieRepository.save(movie);
        }
        return movie;
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    public List<MovieCustomerDTO> findAllCustomersById(Integer id){
        return movieRepository.findMovieAndRenterCustomer(id);
    }

}
