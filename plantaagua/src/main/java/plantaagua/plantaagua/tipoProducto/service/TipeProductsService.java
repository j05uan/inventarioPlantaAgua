package plantaagua.plantaagua.tipoProducto.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;
import plantaagua.plantaagua.tipoProducto.entity.TipeProducts;
import plantaagua.plantaagua.tipoProducto.infraestructure.TipeProductsRepository;

@AllArgsConstructor
@Service
public class TipeProductsService {

    private final TipeProductsRepository tipoProductoRepository;
    private final ModelMapper mapper;

    public Iterable<TipeProducts> findAll(){
        return tipoProductoRepository.findAll();
    }

    public TipeProducts findById(Integer id){
        return tipoProductoRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }


    public TipeProducts create(TipeProducts tipoProducto){
        return  tipoProductoRepository.save(tipoProducto);
    }

    public TipeProducts update(Integer id, TipeProducts tipoProducto){
        TipeProducts tipoProductoFromBd = findById(id);
        mapper.map(tipoProductoFromBd, TipeProducts.class);
        return tipoProductoRepository.save(tipoProducto);
    }

    public void delete(Integer id){
        TipeProducts tipoProductoFromBd = findById(id);
        tipoProductoRepository.delete(tipoProductoFromBd);
    }
    

}
