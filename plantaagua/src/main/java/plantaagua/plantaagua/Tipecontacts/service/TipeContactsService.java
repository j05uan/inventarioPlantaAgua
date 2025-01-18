package plantaagua.plantaagua.Tipecontacts.service;

import plantaagua.plantaagua.Tipecontacts.entity.TipeContacts;
import plantaagua.plantaagua.Tipecontacts.repository.TipeContactsRepository;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class TipeContactsService {

    private final TipeContactsRepository tipeContactsRepository;
    private final ModelMapper mapper;

    public Iterable<TipeContacts> findAll(){
        return tipeContactsRepository.findAll();
    }

    public TipeContacts findById(Integer id){
        return tipeContactsRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public TipeContacts create(TipeContacts tipeContacts){
        TipeContacts tipeContacts2 = mapper.map(tipeContacts, TipeContacts.class);
        return tipeContactsRepository.save(tipeContacts2);
    }

    public TipeContacts update(Integer id, TipeContacts tipeContacts){
        TipeContacts tipeContactFromDb = findById(id);
        mapper.map(tipeContacts, tipeContactFromDb);
        return tipeContactsRepository.save(tipeContactFromDb);
    }

    public void delete(Integer id){
        TipeContacts tipeContactsFromDb = findById(id);
        tipeContactsRepository.delete(tipeContactsFromDb);
    }
}
