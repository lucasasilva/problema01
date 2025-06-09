package com.tickets.dash_tickets.model.repository;

import com.tickets.dash_tickets.model.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes,  Integer> {
}
