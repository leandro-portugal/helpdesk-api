package tech.leandroportugal.helpdesk.controllers;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.leandroportugal.helpdesk.domain.Technical;
import tech.leandroportugal.helpdesk.domain.dtos.TechnicalDTO;
import tech.leandroportugal.helpdesk.servicies.TechnicalService;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/technicals")
public class TechnicalController {

    @Autowired
    TechnicalService service;

    @GetMapping("/{id}")    
    public ResponseEntity<TechnicalDTO> findById(@PathVariable Long id){
        Technical obj = service.findById(id);
        return ResponseEntity.ok().body(new TechnicalDTO(obj));

    }

    @GetMapping
    public ResponseEntity<List<TechnicalDTO>> findAll(){
        List<Technical> list = service.findAll();
        List<TechnicalDTO> listDTO = list.stream().map(obj -> new TechnicalDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TechnicalDTO> create(@Valid @RequestBody TechnicalDTO objDTO){
        Technical obj = service.create(objDTO);
        URI uri = URI.create("/technicals/"+obj.getId());
        return ResponseEntity.created(uri).build();
    
    }
    
}
