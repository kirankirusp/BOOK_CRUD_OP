package com.example.book_crud_op.resolver;

import com.example.book_crud_op.Model.Book;
import com.example.book_crud_op.repository.Book_Repository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Book_Resolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final Book_Repository bookRepository;

    @Autowired
    public Book_Resolver(Book_Repository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book createBook(String name, int price, String author) {
        return bookRepository.savebook(name,price,author);
    }


    public Iterable<Book> getAllBook() {
        return bookRepository.findAll();
    }


    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    public Book updateBook(Long id, String name) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (name != null) {
                book.setName(name);
            }
            return bookRepository.updatename(id,name);
        }
        throw new IllegalArgumentException("Book not found with ID: " + id);
    }


    public Boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
