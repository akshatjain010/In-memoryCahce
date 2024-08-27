/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.greenlearner.LibraryApplication.controller;

import com.greenlearner.LibraryApplication.model.Book;
import com.greenlearner.LibraryApplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
@RequiredArgsConstructor
public class BookController {
    
    private final BookService bookService;
    
    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
    
    @PutMapping("/book/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable long id) {
        return bookService.updateBook(book, id);
    }
    
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }
    
    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable long id) {
        return bookService.deleteBook(id);
    }
}
