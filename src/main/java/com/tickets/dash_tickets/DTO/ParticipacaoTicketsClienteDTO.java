package com.tickets.dash_tickets.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class ParticipacaoTicketsClienteDTO {
    private Integer cliente;
    private Long totalTicketsCliente;
}
