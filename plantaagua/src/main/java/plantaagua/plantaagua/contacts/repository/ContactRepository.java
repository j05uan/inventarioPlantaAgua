package plantaagua.plantaagua.contacts.repository;

import org.springframework.data.repository.CrudRepository;

import plantaagua.plantaagua.contacts.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact,Integer> {

}
