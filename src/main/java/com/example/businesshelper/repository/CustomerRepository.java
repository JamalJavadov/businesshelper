package com.example.businesshelper.repository;

import com.example.businesshelper.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long> {

    Optional<Customer> findCustomerByInstagramName(String instagramName);

}
