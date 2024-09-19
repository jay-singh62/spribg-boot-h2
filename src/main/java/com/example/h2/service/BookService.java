package com.example.h2.service;

import com.example.h2.model.Book;
import com.example.h2.pojo.BookRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {
     ResponseEntity<List<Book>> getAllBooks();
     ResponseEntity<Book> getBookById(@PathVariable long id);
     ResponseEntity<Book> addBook(@RequestBody BookRequest request);
     ResponseEntity<Book> updateBookById(@PathVariable long id, @RequestBody  BookRequest request );
     ResponseEntity<Book> deleteById(@PathVariable long id);
}
