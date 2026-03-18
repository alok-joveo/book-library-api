package com.example.book_library_api.controller;

import com.example.book_library_api.service.BookService;
import com.example.book_library_api.dto.BookDTO;
import com.example.book_library_api.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public Book create(@Valid @RequestBody BookDTO dto){
        return service.createBook(dto);
    }

    @GetMapping
    public List<Book> getAll(){
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable String id){
        return service.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable String id,
                       @Valid @RequestBody BookDTO dto){
        return service.updateBook(id,dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){

        service.deleteBook(id);

        return "Book deleted";
    }
}