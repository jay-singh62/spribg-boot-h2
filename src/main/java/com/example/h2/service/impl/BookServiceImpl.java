package com.example.h2.service.impl;

import com.example.h2.model.Book;
import com.example.h2.pojo.BookRequest;
import com.example.h2.repo.BookRepo;
import com.example.h2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookRepo bookRepo;

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> bookList = new ArrayList<>();
            bookRepo.findAll().forEach(bookList::add);
            if (bookList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Book> getBookById(long id) {
        Optional<Book> bookData = bookRepo.findById(id);
        if (bookData.isPresent()) {
            return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Book> addBook(BookRequest request) {
        String userEmail = request.getEmail();
        Book book = bookRepo.findByEmail(userEmail);
        if (book != null) {
            return new  ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
        Book smallBook = new Book();
        smallBook.setTitle(request.getTitle());
        smallBook.setAuthor(request.getAuthor());
        smallBook.setEmail(request.getEmail());
        Book bookObj = bookRepo.save(smallBook);
        return new ResponseEntity<>(bookObj, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Book> updateBookById(long id, BookRequest request) {
        Optional<Book> oldbBookData = bookRepo.findById(id);
        if (oldbBookData.isPresent()) {
            Book updatBookData = oldbBookData.get();
            updatBookData.setTitle(request.getTitle());
            updatBookData.setAuthor(request.getAuthor());
            updatBookData.setEmail(request.getEmail());
            Book bookObj = bookRepo.save(updatBookData);
            return new ResponseEntity<>(bookObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Book> deleteById(long id) {
        bookRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

