package mk.ukim.finki.emt.eshop.model;

import lombok.Data;
import mk.ukim.finki.emt.eshop.model.enumerations.Category;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer availableCopies;

    @ManyToOne
    private Author author;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    public Book() {

    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.availableCopies = availableCopies;
        this.author = author;
        this.category = category;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
