package plantaagua.plantaagua.tipeDocument.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.Tipecontacts.repository.TipeContactsRepository;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;
import plantaagua.plantaagua.tipeDocument.entity.TipeDocument;
import plantaagua.plantaagua.tipeDocument.repository.TipeDocumentRepository;

@AllArgsConstructor
@Service
public class TipeDocumentService {

    private final TipeDocumentRepository tipeDocumentRepository;
    private final ModelMapper mapper;

    public Iterable<TipeDocument> findAll(){
        return tipeDocumentRepository.findAll();
    }

    public TipeDocument findById(Integer id){
        return tipeDocumentRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public TipeDocument create(TipeDocument tipeDocument){
        TipeDocument tipeDocument2 = mapper.map(tipeDocument, TipeDocument.class);

        return tipeDocumentRepository.save(tipeDocument2);
    }

    public TipeDocument update(Integer id, TipeDocument tipeDocument){
        TipeDocument tipeDocumentFromDb = findById(id);
        mapper.map(tipeDocument, tipeDocumentFromDb);
        return tipeDocumentRepository.save(tipeDocumentFromDb);
    }
      public void delete(Integer id) {
        TipeDocument tipeDocumentFromDb = findById(id);
        tipeDocumentRepository.delete(tipeDocumentFromDb);
    }

}
