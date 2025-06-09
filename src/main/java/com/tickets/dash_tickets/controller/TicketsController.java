package com.tickets.dash_tickets.controller;

import com.tickets.dash_tickets.DTO.FiltroTicketsDTO;
import com.tickets.dash_tickets.DTO.ParticipacaoTicketsModuloDTO;
import com.tickets.dash_tickets.DTO.formataJsonFinalDTO;
import com.tickets.dash_tickets.model.service.TicketsService;
import com.tickets.dash_tickets.model.service.jsonFinalDTOService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketsController {
    private final jsonFinalDTOService jsonFinalDTOService;
    public TicketsController(jsonFinalDTOService jsonFinalDTOService) {
        this.jsonFinalDTOService = jsonFinalDTOService;
    }
//    private TicketsService ticketsService;
//    public TicketsController(TicketsService ticketsService) {
//        this.ticketsService = ticketsService;
//    }


    @PostMapping("/retornar-tickets")
    public ResponseEntity<List<formataJsonFinalDTO>> retornarTickets(@RequestBody FiltroTicketsDTO filtro) {
        return ResponseEntity.ok(jsonFinalDTOService.formataJsonFinalDTO(filtro.getMes(), filtro.getAno()));
    }
}
