package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
