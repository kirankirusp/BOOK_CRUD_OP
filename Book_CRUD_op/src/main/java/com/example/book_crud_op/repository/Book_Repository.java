package com.example.book_crud_op.repository;

import com.example.book_crud_op.Model.Book;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface Book_Repository extends Neo4jRepository<Book,Long> {
    @Query("Create(b:Book{name:$name,price:$price,author:$author})return b")
    Book savebook(String name, int price, String author);
    @Query("Match(b:Book) where id(b)=$id set b.name=$name return b")
    Book updatename(Long id,String name);

    @Query("MATCH(b:Book) RETURN b")
    List<Book> findAll();

    @Query("MATCH(b:Book) WHERE id(b)=$id RETURN b")
    Optional<Book> findById(Long id);

}
