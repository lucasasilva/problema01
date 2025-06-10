package com.tickets.dash_tickets.controller;

import com.tickets.dash_tickets.controller.DTO.FiltroTicketsDTO;
import com.tickets.dash_tickets.controller.DTO.formataJsonFinalDTO;
import com.tickets.dash_tickets.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;

    @PostMapping("/retornar-tickets")
    public ResponseEntity<List<formataJsonFinalDTO>> retornarTickets(@RequestBody FiltroTicketsDTO filtro) {
        try{
            return ResponseEntity.ok(ticketsService.formataJsonFinalDTO(filtro.getMes(), filtro.getAno()));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
