package tech.leandroportugal.helpdesk.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<TicketDTO> create(@Valid  @RequestBody TicketDTO objDTO) {
        Ticket obj = service.create(objDTO);
        URI uri = URI.create("/tickets/"+obj.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity <TicketDTO> update(@PathVariable Long id, @Valid @RequestBody TicketDTO objDTO) {
        Ticket obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new TicketDTO(obj));
    } 

    
    
}


