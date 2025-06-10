package com.tickets.dash_tickets.repository;

import com.tickets.dash_tickets.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Tickets, Integer> {
}
