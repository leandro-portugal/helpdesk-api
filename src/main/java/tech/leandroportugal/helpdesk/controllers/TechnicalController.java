package tech.leandroportugal.helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.leandroportugal.helpdesk.domain.Technical;
import tech.leandroportugal.helpdesk.domain.dtos.TechnicalDTO;
import tech.leandroportugal.helpdesk.servicies.TechnicalService;

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
    
}
