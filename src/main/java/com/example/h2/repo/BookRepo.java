package com.example.h2.repo;

import com.example.h2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  BookRepo extends JpaRepository<Book, Long> {
    public  Book findByEmail(String email);
}
