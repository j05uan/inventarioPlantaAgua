package plantaagua.plantaagua.inventarioProducto.service;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;
import plantaagua.plantaagua.inventarioProducto.entity.ProductInventory;
import plantaagua.plantaagua.inventarioProducto.entity.ProductInventoryDto;
import plantaagua.plantaagua.inventarioProducto.repository.ProductInventoryRepository;


@AllArgsConstructor
@Service
public class ProductInventoryService {

    private final ProductInventoryRepository productInventoryRepository;
    private final ModelMapper mapper;

    public Iterable<ProductInventory> findAll(){
        return productInventoryRepository.findAll();
    }

    public ProductInventory findById(Integer id){
        return productInventoryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public ProductInventory create(ProductInventoryDto productInventoryDto){
        ProductInventory productInventory = mapper.map(productInventoryDto, ProductInventory.class);
        return productInventoryRepository.save(productInventory);
    }

    public ProductInventory update(Integer id, ProductInventoryDto productInventoryDto){
        ProductInventory productInventoryFormDb = findById(id);
        mapper.map(productInventoryDto, productInventoryFormDb);
        return productInventoryRepository.save(productInventoryFormDb);
    }

    public void delete(Integer id){
        ProductInventory productInventoryFromDb = findById(id);
        productInventoryRepository.delete(productInventoryFromDb);
    }

}
