package com.tickets.dash_tickets.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "modulo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "codModulo")
    @JsonIgnore
    private List<Tickets> ticket;
}
