/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.greenlearner.LibraryApplication.serviceimpl;

import com.greenlearner.LibraryApplication.model.Book;
import com.greenlearner.LibraryApplication.repository.BookRepository;
import com.greenlearner.LibraryApplication.service.BookService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    
    private static final Logger logger= LoggerFactory.getLogger(BookServiceImpl.class);
    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        logger.info("adding book with id:- {}", book.getId());
        return bookRepository.save(book);
    }

    @Override
    @CachePut(cacheNames = "books", key = "#book.id")
    public Book updateBook(Book book, long id) {
        bookRepository.updateAddress(id, book.getName());
        logger.info("book updated with new name");
        return book;
    }

    @Override
    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBook(long id) {
        logger.info("fetching book from db");
        Optional<Book> book= bookRepository.findById(id);
        if(book.isPresent()) return book.get();
        else return new Book();
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")
    public String deleteBook(long id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }
    
}
