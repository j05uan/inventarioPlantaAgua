package plantaagua.plantaagua.city.controller;

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
import plantaagua.plantaagua.city.entity.City;
import plantaagua.plantaagua.city.service.CityService;

@AllArgsConstructor
@RequestMapping("/api/city")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

    private final CityService cityService;

    @GetMapping("{id}")
    public City get(@PathVariable Integer id){
        return cityService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public City create(@Validated @RequestBody City city){
        return cityService.create(city);
    }

    @PutMapping("{id}")
    public City update(@PathVariable Integer id, @RequestBody City city){
        return cityService.update(id, city);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        cityService.delete(id);
    }

}
