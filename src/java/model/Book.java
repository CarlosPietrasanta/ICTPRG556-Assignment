/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Pietrasanta
 */
@Entity
@Table(name = "TBOOKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author"),
    @NamedQuery(name = "Book.findByPrice", query = "SELECT b FROM Book b WHERE b.price = :price")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ISBN")
    private String isbn;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 20)
    @Column(name = "AUTHOR")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;

    /**
     * Default Book class Constructor with no parameters.
     */
    public Book() {
    }
    
    /**
     * Constructs a new Book with the specified ISBN, title, author, and price.
     *
     * @param isbn the ISBN identifier of the book
     * @param title the title of the book
     * @param author the author of the book
     * @param price the price of the book
     */
    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return the ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn the new ISBN to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the new title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author the new author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Returns the price of the book.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the book.
     *
     * @param price the new price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    /**
     * Returns a string representation of the book, which includes the title.
     *
     * @return a string representation of the book
     */
    @Override
    public String toString() {
        return "Title: " + title + "  ";
    }

    /**
     * Returns the price of the book formatted as a dollar amount.
     *
     * @return the price of the book formatted as a dollar amount
     */
    public String getDollarPrice() {
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        return "$" + priceFormat.format(this.price);
    }
}
