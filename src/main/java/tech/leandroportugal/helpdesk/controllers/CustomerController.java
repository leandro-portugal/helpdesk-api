package tech.leandroportugal.helpdesk.controllers;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.leandroportugal.helpdesk.domain.Customer;
import tech.leandroportugal.helpdesk.domain.dtos.CustomerDTO;
import tech.leandroportugal.helpdesk.servicies.CustomerService;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("/{id}")    
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id){
        Customer obj = service.findById(id);
        return ResponseEntity.ok().body(new CustomerDTO(obj));

    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll(){
        List<Customer> list = service.findAll();
        List<CustomerDTO> listDTO = list.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO objDTO){
        Customer obj = service.create(objDTO);
        URI uri = URI.create("/Customers/"+obj.getId());
        return ResponseEntity.created(uri).build();
    
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@Valid @RequestBody CustomerDTO objDTO, @PathVariable Long id){
        Customer obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new CustomerDTO(obj));
    
    
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
