package mk.ukim.finki.emt.eshop.web.rest;

import mk.ukim.finki.emt.eshop.model.Author;
import mk.ukim.finki.emt.eshop.model.enumerations.Category;
import mk.ukim.finki.emt.eshop.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    public List<Author> findAll(){
        return this.authorService.findAll();
    }
}
