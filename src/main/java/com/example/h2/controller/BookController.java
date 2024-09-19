package com.example.h2.controller;

import com.example.h2.model.Book;
import com.example.h2.pojo.BookRequest;
import com.example.h2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    // Here we have injected our service
//    @Autowired
//    BookRepo bookRepo;

    @Autowired
    BookService bookService;

    // This is get request to get all the data in database
    // GET:-  localhost:9090/book
    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }

    // This is get request  in these we get data from database through unique id
    // GET:-  localhost:9090/book/123
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    // This is post request thought these we will add new book to our database
    // POST :- localhost:9090/book Body
    @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody BookRequest request) {
        return bookService.addBook(request);
    }

    // this post request will update the existing book details from our database
    //POST:-  localhost:9090/book/123 Body
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable long id, @RequestBody  BookRequest request) {
        return bookService.updateBookById(id,request );
    }

    //  this is delet request which will delet the data of given id from the database
    //DELET:-  localhost:9090/book/123
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deletBookById(@PathVariable long id) {
        return bookService.deleteById(id);
    }


}
