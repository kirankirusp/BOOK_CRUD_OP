package com.example.book_crud_op.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer price;
    private String author;
}
