package com.example.book_library_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.book_library_api.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}