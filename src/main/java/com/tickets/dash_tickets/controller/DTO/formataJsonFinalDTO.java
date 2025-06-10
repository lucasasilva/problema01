package com.tickets.dash_tickets.controller.DTO;

import com.tickets.dash_tickets.entities.Tickets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class formataJsonFinalDTO {
    private List<ParticipacaoTicketsModuloDTO> ticketsPorModulo;
    private List<ParticipacaoTicketsClienteDTO> ticketsPorCliente;
    private List<TicketsDTO> Tickets;


}
