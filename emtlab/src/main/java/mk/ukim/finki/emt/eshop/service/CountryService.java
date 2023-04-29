package mk.ukim.finki.emt.eshop.service;

import mk.ukim.finki.emt.eshop.model.Book;
import mk.ukim.finki.emt.eshop.model.Country;

import java.util.List;

public interface CountryService {

    Country findById(Long id);

    List<Country> findAll();

    Country create(String name, String continent);
}
