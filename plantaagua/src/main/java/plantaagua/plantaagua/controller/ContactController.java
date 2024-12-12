package plantaagua.plantaagua.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.entity.Contact;
import plantaagua.plantaagua.repository.ContactRepository;
import plantaagua.plantaagua.service.ContactService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
// @CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    
    private final ContactService contactService;

    

    @GetMapping    
    public Iterable<Contact> list(){
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        //Para asignarle la fecha y hora actual al valor 
        // contact.setCreatedAt(LocalDateTime.now()) 
        return contactService.create(contact);
    } 
    
    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id, @RequestBody Contact form) {
        //Se traen los datos de la base de datos, para sobre escribir sobre los datos que se desean cambiar, y no actualizar los datos que no deben ser actualizados
        // Contact contactFromDb = contactRepository.findById(id).orElse(null);
        // //Se asignan los valores que se envian el usuario para actualzar
        // contactFromDb.setName(form.getName());
        // contactFromDb.setEmail(form.getEmail());

        return contactService.update(id,form);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        // Contact contactFromDb = contactRepository.findById(id).orElse(null);
        contactService.delete(id);
    }

}
