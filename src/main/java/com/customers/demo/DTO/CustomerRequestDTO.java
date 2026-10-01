package com.customers.demo.DTO;

import com.customers.demo.Entity.Notes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO {
    String name;
    String contact;
    String email;
    String gstin;
    String fail_existing;
    Notes notes;
}
