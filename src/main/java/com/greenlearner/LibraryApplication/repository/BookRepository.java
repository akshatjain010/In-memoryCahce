/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.greenlearner.LibraryApplication.repository;

import com.greenlearner.LibraryApplication.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    @Transactional
    @Modifying
    @Query("update Book u set u.name=?2 where u.id=?1")
    int updateAddress(long id, String name);
}
