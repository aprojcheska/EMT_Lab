package mk.ukim.finki.emt.eshop.service.impl;

import mk.ukim.finki.emt.eshop.model.Author;
import mk.ukim.finki.emt.eshop.model.Book;
import mk.ukim.finki.emt.eshop.model.dto.BookDto;
import mk.ukim.finki.emt.eshop.model.enumerations.Category;
import mk.ukim.finki.emt.eshop.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.eshop.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.eshop.repository.AuthorRepository;
import mk.ukim.finki.emt.eshop.repository.BookRepository;
import mk.ukim.finki.emt.eshop.repository.CountryRepository;
import mk.ukim.finki.emt.eshop.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final CountryRepository countryRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> findAllOrderById() {
        return this.bookRepository.findAllByOrderById();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return Optional.empty();
    }


    @Override
    public Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Book save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
        Book book = new Book(name,category,author,availableCopies);

        return this.bookRepository.save(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book borrowBook(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        if(book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        }
        return this.bookRepository.save(book);
    }

    @Override
    public Book returnBook(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        book.setAvailableCopies(book.getAvailableCopies()+1);
        return this.bookRepository.save(book);
    }
}
