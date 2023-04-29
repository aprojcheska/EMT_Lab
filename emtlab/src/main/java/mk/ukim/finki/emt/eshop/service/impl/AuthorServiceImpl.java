package mk.ukim.finki.emt.eshop.service.impl;

import mk.ukim.finki.emt.eshop.model.Author;
import mk.ukim.finki.emt.eshop.model.Book;
import mk.ukim.finki.emt.eshop.model.Country;
import mk.ukim.finki.emt.eshop.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.eshop.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.eshop.repository.AuthorRepository;
import mk.ukim.finki.emt.eshop.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author create(String name, String surname, Country country) {
        Author author = new Author(name, surname, country);
        return this.authorRepository.save(author);
    }
}
