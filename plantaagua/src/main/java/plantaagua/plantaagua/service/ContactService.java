package plantaagua.plantaagua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import plantaagua.plantaagua.entity.Contact;
import plantaagua.plantaagua.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository; 

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    // public Contact create(Contact contact){
        
    // }
}
