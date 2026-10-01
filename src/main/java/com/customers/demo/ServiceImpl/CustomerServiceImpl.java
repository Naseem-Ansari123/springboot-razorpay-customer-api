package com.customers.demo.ServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.customers.demo.DTO.CustomerRequestDTO;
import com.customers.demo.DTO.CustomerResponseDTO;
import com.customers.demo.Entity.Customers;
import com.customers.demo.Entity.Notes;
import com.customers.demo.Repository.CustomerRepository;
import com.customers.demo.Repository.NotesRepository;
import com.customers.demo.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private NotesRepository notesRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, NotesRepository notesRepository) {
        this.customerRepository = customerRepository;
        this.notesRepository = notesRepository;
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customers customer = new Customers();
        Notes notes = new Notes();

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

        customer.setName(customerRequestDTO.getName());
        customer.setContact(customerRequestDTO.getContact());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setGstin(customerRequestDTO.getGstin());
        customer.setCreated_at(System.currentTimeMillis());

        notes.setNote_key(customerRequestDTO.getNotes().getNote_key());

        Customers savedCustomer = customerRepository.save(customer);
        Notes savedNotes = notesRepository.save(notes);

        customerResponseDTO.setId(savedCustomer.getId());
        customerResponseDTO.setName(savedCustomer.getName());
        customerResponseDTO.setContact(savedCustomer.getContact());
        customerResponseDTO.setEmail(savedCustomer.getEmail());
        customerResponseDTO.setGstin(savedCustomer.getGstin());
        customerResponseDTO.setCreated_at(savedCustomer.getCreated_at());
        customerResponseDTO.setNotes(savedNotes);

        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO updateCustomer(UUID id, CustomerRequestDTO customerRequestDTO) {
        Customers newcustomer = customerRepository.getReferenceById(id);
        System.out.println(newcustomer.getId());
        // Notes notes =
        // notesRepository.getReferenceById(customerRequestDTO.getNotes().getNote_id());

        newcustomer.setName(customerRequestDTO.getName());
        newcustomer.setContact(customerRequestDTO.getContact());
        newcustomer.setEmail(customerRequestDTO.getEmail());
        newcustomer.setGstin(customerRequestDTO.getGstin());
        newcustomer.setCreated_at(System.currentTimeMillis());

        // notes.setNote_key(customerRequestDTO.getNotes().getNote_key());

        customerRepository.save(newcustomer);
        // notesRepository.save(notes);

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

        customerResponseDTO.setId(newcustomer.getId());
        customerResponseDTO.setName(newcustomer.getName());
        customerResponseDTO.setContact(newcustomer.getContact());
        customerResponseDTO.setEmail(newcustomer.getEmail());
        customerResponseDTO.setGstin(newcustomer.getGstin());
        customerResponseDTO.setCreated_at(newcustomer.getCreated_at());
        // customerResponseDTO.setNotes(notes);

        return customerResponseDTO;

    }

    @Override
    public CustomerResponseDTO getCustomer(UUID id) {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        Customers customers = customerRepository.getReferenceById(id);

        customerResponseDTO.setId(customers.getId());
        customerResponseDTO.setName(customers.getName());
        customerResponseDTO.setContact(customers.getContact());
        customerResponseDTO.setEmail(customers.getEmail());
        customerResponseDTO.setGstin(customers.getGstin());
        customerResponseDTO.setEntity(customers.getEntity());
        customerResponseDTO.setShipping_address(customers.getShipping_address());
        customerResponseDTO.setCreated_at(customers.getCreated_at());

        return customerResponseDTO;
    }

    @Override
    public Map<String, Object> fetchAllCustomer(int count, int skip) {
        Pageable pageable = PageRequest.of(skip / count, count);

        Page<Customers> page = customerRepository.findAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("count", page.getTotalElements()); // total records in DB
        response.put("items", page.getContent()); // paginated data

        return response;

    }

}
