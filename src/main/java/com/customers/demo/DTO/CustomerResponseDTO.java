package com.customers.demo.DTO;

import java.util.UUID;

import com.customers.demo.Entity.Notes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerResponseDTO {
    UUID id;
    String name;
    String contact;
    String email;
    String gstin;
    String shipping_address;
    String entity;
    Long created_at;
    Notes notes;
}
