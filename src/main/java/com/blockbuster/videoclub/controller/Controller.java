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

    //Inyección de dependencia del servicio

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

    @GetMapping("/searchAllRentals")  // Esto no funcionará por motivos complejos, se soluciona haciendo una query personalizada que devuelva un DTO, lo cual es bastante normal, no intentes hacerla funcionar, no te preocupes
    public List<MovieRental> searchAllRentals(){
        return movieRentalService.findAllMovieRental();
    }

    @GetMapping("/findAllCustomersFromId/{id}")  // Ya funciona
    public List<MovieCustomerDTO> findAllCustomersFromId(@PathVariable String id){
        return movieService.findAllCustomersById(Integer.parseInt(id));
    }

}
