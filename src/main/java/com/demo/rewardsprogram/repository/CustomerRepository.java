package com.demo.rewardsprogram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.rewardsprogram.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}