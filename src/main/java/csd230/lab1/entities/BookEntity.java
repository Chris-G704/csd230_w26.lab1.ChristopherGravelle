package csd230.lab1.entities;

import csd230.lab1.pojos.Book;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity @DiscriminatorValue("BOOK")
public abstract class BookEntity extends PublicationEntity {
    private String author;
    public BookEntity() {}
    public BookEntity(String t, double p, int c, String a) { super(t, p, c); this.author = a; }
    public String getAuthor() { return author; }
    public void setAuthor(String a) { this.author = a; }

    List<Book> findByIsbn(String isbn) {
        return isbn;
    }

    abstract Book findById(long id);
    @Override public String toString() { return "Book{author='" + author + "', " + super.toString() + "}"; }
}
