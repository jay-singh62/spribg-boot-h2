package com.example.h2.service;

import com.example.h2.model.Book;
import com.example.h2.pojo.BookRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
     ResponseEntity<List<Book>> getAllBooks();
     ResponseEntity<Book> getBookById( long id);
     ResponseEntity<Book> addBook( BookRequest request);
     ResponseEntity<Book> updateBookById(long id,  BookRequest request );
     ResponseEntity<Book> deleteById(long id);
}
