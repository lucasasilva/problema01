package com.tickets.dash_tickets.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class ParticipacaoTicketsClienteDTO {
    private Integer cliente;
    private Long totalTicketsCliente;
}
