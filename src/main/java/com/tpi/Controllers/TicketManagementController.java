package com.tpi.Controllers;

import com.tpi.Exceptions.BadRequestException;
import com.tpi.Model.TicketsManagement;
import com.tpi.Service.TicketsManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/tickets")
public class TicketManagementController {
    private TicketsManagementService ticketsManagementService;

    @GetMapping("/listall")
    public ResponseEntity<List<TicketsManagement>> listAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(ticketsManagementService.ListAllTickets());
    }
    @PostMapping("/save")
    public ResponseEntity<TicketsManagement> saveUser(@RequestBody TicketsManagement ticket){
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketsManagementService.SaveTicket(ticket));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<TicketsManagement> getUserById(@PathVariable Long id) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.FOUND).body(ticketsManagementService.FindTicketByID(id));
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) throws BadRequestException {
        ticketsManagementService.DeleteByID(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
