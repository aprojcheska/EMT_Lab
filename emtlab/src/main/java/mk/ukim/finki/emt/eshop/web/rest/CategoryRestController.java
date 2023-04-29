package mk.ukim.finki.emt.eshop.web.rest;

import mk.ukim.finki.emt.eshop.model.enumerations.Category;
import mk.ukim.finki.emt.eshop.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final BookService bookService;

    public CategoryRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Category> findAll(){
        List<Category> categories = List.of(Category.values());
        return categories;
    }
}
