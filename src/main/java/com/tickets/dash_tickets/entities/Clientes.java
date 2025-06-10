package com.tickets.dash_tickets.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @OneToMany (mappedBy = "codCliente")
    @JsonIgnore
    private List<Tickets> ticket;
}
