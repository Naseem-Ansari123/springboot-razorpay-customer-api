package com.customers.demo.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customers.demo.Entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, UUID> {

}
