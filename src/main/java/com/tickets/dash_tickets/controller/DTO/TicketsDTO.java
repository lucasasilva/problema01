package com.tickets.dash_tickets.controller.DTO;

import com.tickets.dash_tickets.entities.Clientes;
import com.tickets.dash_tickets.entities.Modulo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TicketsDTO {
    private Long id;
    private String nome;
    //precisa levar o nome do cliente e do módulo no front. Mais fácil já trazer aqui junto aos tickets;
    private Clientes codCliente;
    private Modulo codModulo;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;

    public TicketsDTO(int id, String nome, Clientes codCliente, Modulo codModulo, LocalDate dataAbertura, LocalDate dataEncerramento) {
        this.id = (long) id;
        this.nome = nome;
        this.codCliente = codCliente;
        this.codModulo = codModulo;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
    }

}
