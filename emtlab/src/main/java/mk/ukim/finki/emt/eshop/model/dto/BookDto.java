package mk.ukim.finki.emt.eshop.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.eshop.model.enumerations.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BookDto {

    private String name;

    private Integer availableCopies;


@Enumerated(EnumType.STRING)
    private Category category;

    private Long author;

    public BookDto() {
    }

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
