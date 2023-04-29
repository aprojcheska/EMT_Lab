package mk.ukim.finki.emt.eshop.service.impl;

import mk.ukim.finki.emt.eshop.model.Country;
import mk.ukim.finki.emt.eshop.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.eshop.repository.CountryRepository;
import mk.ukim.finki.emt.eshop.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country create(String name, String continent) {
        Country country = new Country(name, continent);
        return this.countryRepository.save(country);
    }
}
