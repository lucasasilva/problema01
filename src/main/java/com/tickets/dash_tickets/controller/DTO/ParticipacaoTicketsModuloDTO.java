package com.tickets.dash_tickets.controller.DTO;

import com.tickets.dash_tickets.entities.Modulo;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ParticipacaoTicketsModuloDTO {
    private Modulo modulo;
    private Long qtdTicketsMes;
}
