package com.unzilemedet.repository;


import com.unzilemedet.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {


    Optional<Customer> findByEmailAndPassword(String email, String password);
}