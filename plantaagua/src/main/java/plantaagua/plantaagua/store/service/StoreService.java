package plantaagua.plantaagua.store.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;
import plantaagua.plantaagua.store.entity.Store;
import plantaagua.plantaagua.store.entity.StoreDTO;
import plantaagua.plantaagua.store.repository.StoreRepository;

@AllArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final ModelMapper mapper;

    public Iterable<Store> findAll(){
        return storeRepository.findAll();
    }

    public Store findById(Integer id){
        return storeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Store create(StoreDTO storeDTO){
        Store store = mapper.map(storeDTO, Store.class);
        return storeRepository.save(store);
    }

    public Store update(Integer id, StoreDTO storeDTO){
        Store storeFromBd = findById(id);
        mapper.map(storeDTO, storeFromBd);
        return storeRepository.save(storeFromBd);
    }

    public void delete(Integer id){
        Store storeFromBd = findById(id);
        storeRepository.delete(storeFromBd);
    }

}
