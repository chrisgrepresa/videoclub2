package com.blockbuster.videoclub.service;

import com.blockbuster.videoclub.dao.Customer;
import com.blockbuster.videoclub.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }
}
