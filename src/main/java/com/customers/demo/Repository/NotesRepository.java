package com.customers.demo.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customers.demo.Entity.Notes;

public interface NotesRepository extends JpaRepository<Notes, UUID> {

}
