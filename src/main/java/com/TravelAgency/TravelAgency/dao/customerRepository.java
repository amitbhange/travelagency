package com.TravelAgency.TravelAgency.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TravelAgency.TravelAgency.entity.Customer;

public interface customerRepository extends JpaRepository<Customer, Integer> {

}
