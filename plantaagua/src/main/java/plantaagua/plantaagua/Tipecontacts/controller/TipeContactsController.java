package plantaagua.plantaagua.Tipecontacts.controller;

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
import plantaagua.plantaagua.Tipecontacts.entity.TipeContacts;
import plantaagua.plantaagua.Tipecontacts.service.TipeContactsService;

@AllArgsConstructor
@RequestMapping("/api/tipeContacts")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TipeContactsController {

    private final TipeContactsService tipeContactsService;

    @GetMapping
    public Iterable<TipeContacts> list(){
        return tipeContactsService.findAll();
    }
    
    @GetMapping("{id}")
    public TipeContacts get(@PathVariable Integer id){
        return tipeContactsService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TipeContacts create(@Validated @RequestBody TipeContacts tipeContacts){
        return tipeContactsService.create(tipeContacts);
    }

    @PutMapping("{id}")
    public TipeContacts update(@PathVariable Integer id, @Validated @RequestBody TipeContacts tipeContacts){
        return tipeContactsService.update(id, tipeContacts);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        tipeContactsService.delete(id);
    }}
