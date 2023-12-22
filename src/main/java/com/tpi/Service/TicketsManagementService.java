package com.tpi.Service;

import com.tpi.Exceptions.BadRequestException;
import com.tpi.Model.TicketsManagement;
import com.tpi.Repository.TicketsManagementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketsManagementService {

    private final TicketsManagementRepository ticketsManagementRepository;

    public TicketsManagement SaveTicket(TicketsManagement ticket){
        if (ticketsManagementRepository.findByEmail(ticket.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use.");
        }
        return ticketsManagementRepository.save(ticket);
    }

    public List<TicketsManagement> ListAllTickets(){
        return ticketsManagementRepository.findAll();
    }


    public TicketsManagement FindTicketByID(Long id) throws BadRequestException {
        Optional<TicketsManagement> ticket = ticketsManagementRepository.findById(id);
        if (ticket.isPresent()){
            return ticketsManagementRepository.findById(id).get();
        }else{
            throw new BadRequestException("This ticket doesn't exist");
        }
    }

    public void DeleteByID(Long id) throws BadRequestException {
        Optional<TicketsManagement> ticket = ticketsManagementRepository.findById(id);
        if (ticket.isPresent()) {
            ticketsManagementRepository.delete(ticket.get());
        } else {
            throw new BadRequestException("This ticket can't be deleted since it doesn't exist");
        }
    }
}
