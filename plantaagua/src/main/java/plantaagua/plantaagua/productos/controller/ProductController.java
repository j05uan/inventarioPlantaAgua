package plantaagua.plantaagua.productos.controller;

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
import plantaagua.plantaagua.productos.service.ProductService;
import plantaagua.plantaagua.tipoProducto.entity.ProductDTO;

@AllArgsConstructor
@RequestMapping("/api/products")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Iterable<Porducto>list(){
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Porducto get(@PathVariable Integer id){
        return productService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Porducto create(@Validated @RequestBody ProductDTO productDTO){
        return productService.create(productDTO);
    }

    @PutMapping("{id}")
    public Porducto update(@PathVariable Integer id, @Validated @RequestBody ProductDTO productDTO){
        return productService.update(id, productDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }

}
