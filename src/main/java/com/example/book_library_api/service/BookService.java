package com.example.book_library_api.service;

import com.example.book_library_api.dto.BookDTO;
import com.example.book_library_api.model.Book;
import com.example.book_library_api.repository.BookRepository;
import com.example.book_library_api.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository repository;

    public Book createBook(BookDTO dto){

        logger.info("Creating book {}", dto.getTitle());

        Book book=new Book();

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        book.setPrice(dto.getPrice());
        book.setPublishedYear(dto.getPublishedYear());

        return repository.save(book);
    }

    public List<Book> getAllBooks(){

        logger.info("Fetching books");

        return repository.findAll();
    }

    public Book getBookById(String id){

        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Book not found"));
    }

    public Book updateBook(String id,BookDTO dto){

        Book book=getBookById(id);

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        book.setPrice(dto.getPrice());
        book.setPublishedYear(dto.getPublishedYear());

        return repository.save(book);
    }

    public void deleteBook(String id){

        Book book=getBookById(id);

        repository.delete(book);
    }
}