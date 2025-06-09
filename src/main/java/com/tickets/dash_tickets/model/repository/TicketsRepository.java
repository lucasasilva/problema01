package com.tickets.dash_tickets.model.repository;

import com.tickets.dash_tickets.model.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Tickets, Integer> {
}
