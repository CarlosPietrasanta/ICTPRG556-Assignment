/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Book;

/**
 * Stateless service bean for managing book related database operations.
 * Provides methods to retrieve book data from the database using JPA.
 * 
 * @author Carlos Pietrasanta
 */
@Stateless
public class BookService {

    @PersistenceContext(unitName = "BookShopPU")
    private EntityManager em;

    /**
     * Retrieves all books from the database.
     * Uses the named query "Book.findAll".
     *
     * @return a list of all books
     */
    public List<Book> findAllBooks() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }
}