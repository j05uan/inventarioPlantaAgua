package plantaagua.plantaagua.store.controller;

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
import plantaagua.plantaagua.productos.entity.Porducto;
import plantaagua.plantaagua.store.entity.Store;
import plantaagua.plantaagua.store.entity.StoreDTO;
import plantaagua.plantaagua.store.service.StoreService;
import plantaagua.plantaagua.tipoProducto.entity.ProductDTO;

@AllArgsConstructor
@RequestMapping("/api/store")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StoreController {

    private final StoreService storeService;

     @GetMapping
    public Iterable<Store>list(){
        return storeService.findAll();
    }

    @GetMapping("{id}")
    public Store get(@PathVariable Integer id){
        return storeService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Store create(@Validated @RequestBody StoreDTO storeDTO){
        return storeService.create(storeDTO);
    }

    @PutMapping("{id}")
    public Store update(@PathVariable Integer id, @Validated @RequestBody StoreDTO storeDTO){
        return storeService.update(id, storeDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        storeService.delete(id);
    }


}
