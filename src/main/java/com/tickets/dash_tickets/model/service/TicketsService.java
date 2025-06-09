package com.tickets.dash_tickets.model.service;

import com.tickets.dash_tickets.DTO.ParticipacaoTicketsClienteDTO;
import com.tickets.dash_tickets.DTO.ParticipacaoTicketsModuloDTO;
import com.tickets.dash_tickets.model.entities.Clientes;
import com.tickets.dash_tickets.model.entities.Modulo;
import com.tickets.dash_tickets.model.entities.Tickets;
import com.tickets.dash_tickets.model.repository.ClientesRepository;
import com.tickets.dash_tickets.model.repository.ModuloRepository;
import com.tickets.dash_tickets.model.repository.TicketsRepository;
import org.springframework.stereotype.Service;


import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;


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

    //agrupamento por cliente. Recebe mês e ano, retorna qtd de tickets abertos naquele período;
    public List<ParticipacaoTicketsClienteDTO> totalTicketsCliente(Integer mes, Integer ano){
        List<ParticipacaoTicketsClienteDTO> ticketsClienteDTOS = new ArrayList<>();
        List<Tickets> tickets = filterByMonthAndYear(mes, ano);
        List<Clientes> clientes = clientesRepository.findAll();
        for (Clientes cliente : clientes) {
            Long  contagem = tickets.stream()
                            .filter(t->t.getCodCliente().getId().equals(cliente.getId()))
                            .count();
            if (contagem > 0) {
                ticketsClienteDTOS.add(new ParticipacaoTicketsClienteDTO(cliente.getId(), contagem));
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
                ticketsModuloDTOS.add(new ParticipacaoTicketsModuloDTO(modulo.getId(), contagem));
            }
        }
        return ticketsModuloDTOS;
    }

}
