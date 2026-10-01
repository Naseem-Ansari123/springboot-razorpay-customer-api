package com.customers.demo.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Customer")

public class Customers<JSON> {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(name = "name", nullable = true)
    String name;

    @Column(nullable = true)
    String contact;

    @Column(nullable = true)
    String entity;

    @Column(nullable = true)
    String email;

    @Column(nullable = true)
    String gstin;

    @Column(nullable = true)
    String shipping_address;

    @Column(nullable = true)
    Long created_at;

}
