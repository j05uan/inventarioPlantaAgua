package plantaagua.plantaagua.productos.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;
import plantaagua.plantaagua.productos.entity.Porducto;
import plantaagua.plantaagua.productos.entity.ProductDTO;
import plantaagua.plantaagua.productos.repository.ProductRepository;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public Iterable<Porducto> findAll(){
        return productRepository.findAll();
    }

    public Porducto findById(Integer id){
        return productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Porducto create(ProductDTO productDTO){
        Porducto porducto = mapper.map(productDTO, Porducto.class);
        return productRepository.save(porducto);
    }

    public Porducto update(Integer id, ProductDTO productDTO){
        Porducto porductoFromBd = findById(id);
        mapper.map(productDTO, porductoFromBd);
        return productRepository.save(porductoFromBd);
    }

    public void delete(Integer id){
        Porducto porductoFromBd = findById(id);
        productRepository.delete(porductoFromBd);
    }

}
