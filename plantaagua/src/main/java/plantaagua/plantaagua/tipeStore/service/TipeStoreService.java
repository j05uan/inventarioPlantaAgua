package plantaagua.plantaagua.tipeStore.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.contacts.dto.ContactDTO;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;
import plantaagua.plantaagua.tipeStore.entity.TipeStore;
import plantaagua.plantaagua.tipeStore.repository.TipeStoreRepository;

@AllArgsConstructor
@Service
public class TipeStoreService {

    private final TipeStoreRepository tipeStoreRepository;
    private final ModelMapper mapper;

    public Iterable<TipeStore> findAll(){
        return tipeStoreRepository.findAll();
    }
     public TipeStore findById(Integer id) {
        return tipeStoreRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }


    public TipeStore create(TipeStore tipeStore){
        TipeStore tipeStore2 = mapper.map(tipeStore, TipeStore.class);
        return tipeStoreRepository.save(tipeStore2);
    }

    public TipeStore update(Integer id, TipeStore tipeStore) {
        TipeStore tipeStoreFromDb = findById(id);
        mapper.map(tipeStore, tipeStoreFromDb);

        return tipeStoreRepository.save(tipeStoreFromDb);
    }

    public void delete(Integer id) {
        TipeStore tipeStoreFromDb = findById(id);
        tipeStoreRepository.delete(tipeStoreFromDb);
    }


}
