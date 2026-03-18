package com.example.book_library_api.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<String> handleResource(
            ResourceNotFoundException ex){

        return new ResponseEntity<>(ex.getMessage(),
                HttpStatus.NOT_FOUND);
    }

}