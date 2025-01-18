package plantaagua.plantaagua.region.controller;

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
import plantaagua.plantaagua.region.entity.Region;
import plantaagua.plantaagua.region.service.RegionService;

@AllArgsConstructor
@RequestMapping("/api/region")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public Iterable<Region> list(){
        return regionService.findAll();
    }

    @GetMapping("{id}")
    public Region get(@PathVariable Integer id){
        return regionService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Region create(@Validated @RequestBody Region region){
        return regionService.create(region);
    }

    @PutMapping("{id}")
    public Region update(@PathVariable Integer id, @Validated @RequestBody Region region){

        return regionService.update(id, region);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        regionService.delete(id);
    }

}
