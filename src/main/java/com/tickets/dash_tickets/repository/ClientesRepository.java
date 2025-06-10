package com.tickets.dash_tickets.repository;

import com.tickets.dash_tickets.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes,  Integer> {
}
