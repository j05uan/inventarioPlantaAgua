package plantaagua.plantaagua.tipoProducto.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.tipoProducto.entity.TipeProducts;
import plantaagua.plantaagua.tipoProducto.service.TipeProductsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@AllArgsConstructor
@RequestMapping("/api/tipeProducts")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TipeProductsController {
    private final TipeProductsService tipoProductoService;

    @GetMapping
    public Iterable<TipeProducts> list(){
        return tipoProductoService.findAll();
    }

    @GetMapping("{id}")
    public TipeProducts get(@PathVariable Integer id) {
        return tipoProductoService.findById(id);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TipeProducts create(@Validated @RequestBody TipeProducts tipeProducts){
        return tipoProductoService.create(tipeProducts);
    }

    @PutMapping("{id}")
    public TipeProducts update(@PathVariable Integer id, @Validated @RequestBody TipeProducts tipeProducts){
        return tipoProductoService.update(id, tipeProducts);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        tipoProductoService.delete(id);
    }
}
