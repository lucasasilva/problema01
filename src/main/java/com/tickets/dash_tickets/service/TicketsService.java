package com.tickets.dash_tickets.service;

import com.tickets.dash_tickets.controller.DTO.ParticipacaoTicketsClienteDTO;
import com.tickets.dash_tickets.controller.DTO.ParticipacaoTicketsModuloDTO;
import com.tickets.dash_tickets.controller.DTO.TicketsDTO;
import com.tickets.dash_tickets.controller.DTO.formataJsonFinalDTO;
import com.tickets.dash_tickets.entities.Clientes;
import com.tickets.dash_tickets.entities.Modulo;
import com.tickets.dash_tickets.entities.Tickets;
import com.tickets.dash_tickets.repository.ClientesRepository;
import com.tickets.dash_tickets.repository.ModuloRepository;
import com.tickets.dash_tickets.repository.TicketsRepository;
import org.springframework.stereotype.Service;


import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TicketsService {
    TicketsRepository ticketsRepository;
    ClientesRepository clientesRepository;
    ModuloRepository moduloRepository;
    public TicketsService(TicketsRepository ticketsRepository,  ClientesRepository clientesRepository, ModuloRepository moduloRepository) {
        this.ticketsRepository = ticketsRepository;
        this.clientesRepository = clientesRepository;
        this.moduloRepository = moduloRepository;
    }


   //filtrar por mês e ano de abertura
    public List<Tickets> filterByMonthAndYear(Integer mes, Integer ano){
        YearMonth anoMes = YearMonth.of(ano, mes);
        List<Tickets> tickets = ticketsRepository.findAll();
        return tickets.stream()
                      .filter(t -> YearMonth.from(t.getDataAbertura()).equals(anoMes))
                      .toList();
    }

    //retornar tickets filtrados para JSON
    public List<TicketsDTO> retornaTodosTickets(Integer mes, Integer ano){
        List<Tickets> tickets = filterByMonthAndYear(mes, ano);
        return tickets.stream().map(Tickets::toDTO).collect(Collectors.toList());
    }

    //agrupamento por cliente
    public List<ParticipacaoTicketsClienteDTO> totalTicketsCliente(Integer mes, Integer ano){
        List<ParticipacaoTicketsClienteDTO> ticketsClienteDTOS = new ArrayList<>();
        List<Tickets> tickets = filterByMonthAndYear(mes, ano);
        List<Clientes> clientes = clientesRepository.findAll();
        for (Clientes cliente : clientes) {
            Long  contagem = tickets.stream()
                            .filter(t->t.getCodCliente().getId().equals(cliente.getId()))
                            .count();
            if (contagem > 0) {
                ticketsClienteDTOS.add(new ParticipacaoTicketsClienteDTO(cliente, contagem));
            }
        }
        return ticketsClienteDTOS;
    }

    //agrupamento por modulo
    public List<ParticipacaoTicketsModuloDTO>  totalTicketsModulo(Integer mes, Integer ano){
        List<ParticipacaoTicketsModuloDTO> ticketsModuloDTOS = new ArrayList<>();
        List<Tickets> tickets = filterByMonthAndYear(mes, ano);
        List<Modulo> modulos = moduloRepository.findAll();
        for (Modulo modulo : modulos) {
            Long contagem = tickets.stream()
                    .filter(t-> t.getCodModulo().getId().equals(modulo.getId()))
                    .count();
            if (contagem > 0) {
                ticketsModuloDTOS.add(new ParticipacaoTicketsModuloDTO(modulo, contagem));
            }
        }
        return ticketsModuloDTOS;
    }

    //Retorna o JSON final formatado com os dados
    public List<formataJsonFinalDTO> formataJsonFinalDTO(Integer mes, Integer ano) {
        List<formataJsonFinalDTO> formataJsonFinalDTO = new ArrayList<>();
        formataJsonFinalDTO.add(new formataJsonFinalDTO(totalTicketsModulo(mes, ano), totalTicketsCliente(mes, ano),retornaTodosTickets(mes,ano)));
        return formataJsonFinalDTO;
    }

    //criar ticket
    public void criarTicket(Tickets tickets){
        ticketsRepository.save(tickets);
    }

    //TODO implementar o swagger - Documentação

}
