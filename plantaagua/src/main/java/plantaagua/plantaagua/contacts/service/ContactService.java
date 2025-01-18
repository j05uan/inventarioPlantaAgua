package plantaagua.plantaagua.contacts.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.contacts.dto.ContactDTO;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.contacts.repository.ContactRepository;
import plantaagua.plantaagua.customer.entity.Customer;
import plantaagua.plantaagua.exceptions.ResourceNotFoundException;


@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }


    public Contact create(ContactDTO contactDTO){
        //Se instala maper en las dependencias, y se utiliza para que mapee cada uno de los atributos de la entidad que se necesita
        Contact contact = mapper.map(contactDTO, Contact.class);
        // contact.setName(contactDTO.getName());
        // contact.setEmail(contactDTO.getEmail());
        contact.setCreatedAt(LocalDateTime.now()); 
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDTO contactDTO) {
        //Se traen los datos de la base de datos, para sobre escribir sobre los datos que se desean cambiar, y no actualizar los datos que no deben ser actualizados
        Contact contactFromDb = findById(id);
        mapper.map(contactDTO, contactFromDb);
        //Se asignan los valores que se envian el usuario para actualzar
        // contactFromDb.setName(contactDTO.getName());
        // contactFromDb.setEmail(contactDTO.getEmail());

        return contactRepository.save(contactFromDb);
    }

    public void delete(Integer id) {
        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }

}
