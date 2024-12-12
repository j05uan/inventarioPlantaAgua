package plantaagua.plantaagua.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.entity.Contact;
import plantaagua.plantaagua.repository.ContactRepository;


@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository; 

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }


    public Contact create(Contact contact){
        contact.setCreatedAt(LocalDateTime.now()); 
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, Contact form) {
        //Se traen los datos de la base de datos, para sobre escribir sobre los datos que se desean cambiar, y no actualizar los datos que no deben ser actualizados
        Contact contactFromDb = findById(id);
        //Se asignan los valores que se envian el usuario para actualzar
        contactFromDb.setName(form.getName());
        contactFromDb.setEmail(form.getEmail());

        return contactRepository.save(contactFromDb);
    }

    public void delete(Integer id) {
        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }

}
