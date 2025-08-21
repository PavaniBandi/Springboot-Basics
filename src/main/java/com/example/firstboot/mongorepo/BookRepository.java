package com.example.firstboot.mongorepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.firstboot.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
