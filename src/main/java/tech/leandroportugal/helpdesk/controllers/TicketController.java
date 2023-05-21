package tech.leandroportugal.helpdesk.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.leandroportugal.helpdesk.domain.Ticket;
import tech.leandroportugal.helpdesk.domain.dtos.TicketDTO;
import tech.leandroportugal.helpdesk.servicies.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    
    @Autowired
    private TicketService service;


    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> findById(@PathVariable Long id) {
        Ticket obj = service.findById(id);
        return ResponseEntity.ok().body(new TicketDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<TicketDTO>> findAll() {
        List<Ticket> list = service.findAll();
        List<TicketDTO> listDTO = list.stream().map(obj -> new TicketDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}


