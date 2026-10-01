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
@Table(name = "Notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID note_id;

    @Column(nullable = true)
    String note_key;
}
