package tech.leandroportugal.helpdesk.controllers.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import tech.leandroportugal.helpdesk.servicies.exceptions.DataIntegrityViolationException;
import tech.leandroportugal.helpdesk.servicies.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ExceptionsHandlerController {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity <StandardError> objectNotFoundException(ObjectNotFoundException e, 
    HttpServletRequest request) {
    
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not Found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    } 

      
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity <StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, 
    HttpServletRequest request) {
    
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Data Integrity Violation", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    } 
}