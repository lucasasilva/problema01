package com.tickets.dash_tickets.model.service;

import com.tickets.dash_tickets.DTO.formataJsonFinalDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class jsonFinalDTOService {

    /*Como só pode fazer 1 chamada, manda todos os dados já formatados para o front em um único JSON
    * */
    TicketsService ticketsService;
    public jsonFinalDTOService(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    public List<formataJsonFinalDTO> formataJsonFinalDTO(Integer mes, Integer ano) {
        List<formataJsonFinalDTO> formataJsonFinalDTO = new ArrayList<>();
        formataJsonFinalDTO.add(new formataJsonFinalDTO(ticketsService.totalTicketsModulo(mes, ano), ticketsService.totalTicketsCliente(mes, ano), ticketsService.filterByMonthAndYear(mes, ano)));
        return formataJsonFinalDTO;
    }
}
