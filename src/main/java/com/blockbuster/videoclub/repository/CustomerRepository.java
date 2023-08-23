package com.blockbuster.videoclub.repository;

import com.blockbuster.videoclub.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

