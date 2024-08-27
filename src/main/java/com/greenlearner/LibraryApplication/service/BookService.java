/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.greenlearner.LibraryApplication.service;

import com.greenlearner.LibraryApplication.model.Book;

/**
 *
 * @author Lenovo
 */
public interface BookService {
    Book addBook(Book book);
    Book updateBook(Book book, long id);
    Book getBook(long id);
    String deleteBook(long id);
}
