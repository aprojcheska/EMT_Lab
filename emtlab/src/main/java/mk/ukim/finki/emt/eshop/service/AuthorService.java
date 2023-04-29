package mk.ukim.finki.emt.eshop.service;

import mk.ukim.finki.emt.eshop.model.Author;
import mk.ukim.finki.emt.eshop.model.Book;
import mk.ukim.finki.emt.eshop.model.Country;

import java.util.List;

public interface AuthorService {

    Author findById(Long id);

    List<Author> findAll();

    Author create(String name, String surname, Country country);
}
