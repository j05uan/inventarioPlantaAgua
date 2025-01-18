package plantaagua.plantaagua.tipeStore.controller;

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
import plantaagua.plantaagua.contacts.dto.ContactDTO;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.tipeStore.entity.TipeStore;
import plantaagua.plantaagua.tipeStore.service.TipeStoreService;

@AllArgsConstructor
@RequestMapping("/api/tipeStore")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TipeStoreController {

    private final TipeStoreService tipeStoreService;

    @GetMapping    
    public Iterable<TipeStore> list(){
        return tipeStoreService.findAll();
    }

    @GetMapping("{id}")
    public TipeStore get(@PathVariable Integer id) {
        return tipeStoreService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TipeStore create(@Validated @RequestBody TipeStore tipeStore) {
        return tipeStoreService.create(tipeStore);
    } 
    
    @PutMapping("{id}")
    public TipeStore update(@PathVariable Integer id,@Validated @RequestBody TipeStore tipeStore) {
        
        return tipeStoreService.update(id,tipeStore);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        tipeStoreService.delete(id);
    }

}
