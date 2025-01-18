package plantaagua.plantaagua.coutry.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.coutry.entity.Country;
import plantaagua.plantaagua.coutry.service.CountryService;

@AllArgsConstructor
@RequestMapping("/api/country")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("{id}")
    public Country get(@PathVariable Integer id){
        return countryService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Country create(@Validated @RequestBody Country country){
        return countryService.create(country);
    }

    @PutMapping("{id}")
    public Country update(@PathVariable Integer id, @Validated @RequestBody Country country){

        return countryService.update(id, country);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        countryService.delete(id);
    }

}
