package com.blockbuster.videoclub.controller;

import com.blockbuster.videoclub.dao.Customer;
import com.blockbuster.videoclub.dao.Movie;
import com.blockbuster.videoclub.dao.MovieRental;
import com.blockbuster.videoclub.dto.MovieCustomerDTO;
import com.blockbuster.videoclub.service.CustomerService;
import com.blockbuster.videoclub.service.MovieRentalService;
import com.blockbuster.videoclub.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final MovieService movieService;
    private final CustomerService customerService;
    private final MovieRentalService movieRentalService;

    public Controller(MovieService movieService, CustomerService customerService, MovieRentalService movieRentalService) {
        this.movieService = movieService;
        this.customerService = customerService;
        this.movieRentalService = movieRentalService;
    }

    @GetMapping("/searchall")
    public List<Movie> searchAllMovies(){
        return movieService.searchAllMovies();
    }

    @GetMapping("/searchbyid/{id}")
    public Optional<Movie> searchById(@PathVariable Integer id){
        return movieService.searchById(id);
    }

    @PostMapping("/savenew")
    public Movie saveNewMovie(@RequestBody Movie movie){
        return movieService.saveNewMovie(movie);
    }

    @PutMapping("/movie/modify/{id}")
    public ResponseEntity<Movie> modifyMovie (@PathVariable String id, @RequestBody Movie movie)
    {
        Movie newMovie = movieService.modifyMovie(Integer.parseInt(id), movie);
        return ResponseEntity.ok(newMovie);
    }

    @DeleteMapping("/movie/delete/{id}")
    public void deleteMovie (@PathVariable String id){
        movieService.deleteMovie(Integer.parseInt(id));
    }

    @GetMapping("/searchAllCustomers")
    public List<Customer> searchAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/searchAllRentals")
    public List<MovieRental> searchAllRentals(){
        return movieRentalService.findAllMovieRental();
    }

    @GetMapping("/findAllCustomersFromMovieId/{id}")
    public List<MovieCustomerDTO> findAllCustomersFromMovieId(@PathVariable String id){
        return movieService.findAllCustomersByMovieId(Integer.parseInt(id));
    }


}
