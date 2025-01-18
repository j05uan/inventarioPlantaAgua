package plantaagua.plantaagua.tipeDocument.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import plantaagua.plantaagua.Tipecontacts.service.TipeContactsService;
import plantaagua.plantaagua.contacts.dto.ContactDTO;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.tipeDocument.entity.TipeDocument;
import plantaagua.plantaagua.tipeDocument.service.TipeDocumentService;

@AllArgsConstructor
@RequestMapping("/api/tipeDocuments")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TipeDocumentController {

    private final TipeDocumentService tipeDocumentService;

    @GetMapping
    public Iterable<TipeDocument> list(){
        return tipeDocumentService.findAll();
    }

    @GetMapping("{id}")
    public TipeDocument get(@PathVariable Integer id) {
        return tipeDocumentService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TipeDocument create(@Validated @RequestBody TipeDocument tipeDocument) {
        //Para asignarle la fecha y hora actual al valor 
        // contact.setCreatedAt(LocalDateTime.now()) 
        return tipeDocumentService.create(tipeDocument);
    } 
    
    @PutMapping("{id}")
    public TipeDocument update(@PathVariable Integer id,@Validated @RequestBody TipeDocument tipeDocument) {

        return tipeDocumentService.update(id,tipeDocument);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        tipeDocumentService.delete(id);
    }

}
