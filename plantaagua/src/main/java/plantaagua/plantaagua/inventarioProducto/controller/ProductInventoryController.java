package plantaagua.plantaagua.inventarioProducto.controller;

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
import plantaagua.plantaagua.inventarioProducto.entity.ProductInventory;
import plantaagua.plantaagua.inventarioProducto.entity.ProductInventoryDto;
import plantaagua.plantaagua.inventarioProducto.service.ProductInventoryService;
import plantaagua.plantaagua.productos.entity.Porducto;
import plantaagua.plantaagua.productos.entity.ProductDTO;

@AllArgsConstructor
@RequestMapping("/api/productInventory")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductInventoryController {

    private final ProductInventoryService productInventoryService;

    @GetMapping("{id}")
    public ProductInventory get(@PathVariable Integer id){
        return productInventoryService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductInventory create(@Validated @RequestBody ProductInventoryDto productDTO){
        return productInventoryService.create(productDTO);
    }

    @PutMapping("{id}")
    public ProductInventory update(@PathVariable Integer id, @Validated @RequestBody ProductInventoryDto productDTO){
        return productInventoryService.update(id, productDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        productInventoryService.delete(id);
    }

}
