package com.tickets.dash_tickets.DTO;

import com.tickets.dash_tickets.model.entities.Tickets;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class formataJsonFinalDTO {
    private List<ParticipacaoTicketsModuloDTO> ticketsModuloDTOS;
    private List<ParticipacaoTicketsClienteDTO> participacaoTicketsClienteDTOS;
    private List<Tickets> tickets;
}
