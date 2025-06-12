package com.tickets.dash_tickets.controller.DTO;

import com.tickets.dash_tickets.entities.Clientes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class ParticipacaoTicketsClienteDTO {
    private Clientes cliente;
    private Long totalTicketsCliente;
}
