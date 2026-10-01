package com.customers.demo.Controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customers.demo.DTO.CustomerRequestDTO;
import com.customers.demo.DTO.CustomerResponseDTO;
import com.customers.demo.Service.CustomerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/v1")

public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return new ResponseEntity<>(customerService.createCustomer(customerRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/customers")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@RequestParam UUID id,
            @RequestBody CustomerRequestDTO customerRequestDTO) {
        return new ResponseEntity<>(customerService.updateCustomer(id, customerRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@RequestParam UUID id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @GetMapping("/allcustomers")
    public Map<String, Object> fetchAllCustomer(@RequestParam(defaultValue = "10") int count,
            @RequestParam(defaultValue = "0") int skip) {
        return customerService.fetchAllCustomer(count, skip);
    }

}
