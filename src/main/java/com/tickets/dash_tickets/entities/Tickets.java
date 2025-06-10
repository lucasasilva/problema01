package com.tickets.dash_tickets.entities;


import com.tickets.dash_tickets.controller.DTO.TicketsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ticket")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String nome;
    @ManyToOne
    @JoinColumn(name="FK_ID_CLIENT")
    private Clientes codCliente;

    @ManyToOne
    @JoinColumn(name = "FK_ID_MODULE")
    private Modulo codModulo;

    @Column(name = "opening_date")
    private LocalDate dataAbertura;
    @Column(name = "closing_date")
    private LocalDate dataEncerramento;

    public TicketsDTO toDTO(){
        return new TicketsDTO(this.id, this.nome, this.codCliente, this.codModulo, this.dataAbertura, this.dataEncerramento);
    }

}
