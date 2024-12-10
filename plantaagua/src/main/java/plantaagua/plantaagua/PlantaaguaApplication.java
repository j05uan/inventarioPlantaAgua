package plantaagua.plantaagua;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import plantaagua.plantaagua.entity.Contact;
import plantaagua.plantaagua.repository.ContactRepository;

@SpringBootApplication
public class PlantaaguaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantaaguaApplication.class, args);
	};

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
    return args -> {
        List<Contact> contacts = Arrays.asList(
            new Contact("Carlos", "carlos@gmail.com", LocalDateTime.now()),
            new Contact("Juan", "Juan@gmail.com", LocalDateTime.now()),
            new Contact("Marcelo", "Marcelo@gmail.com", LocalDateTime.now()),
            new Contact("Luis", "Luis@gmail.com", LocalDateTime.now())
        );
        contactRepository.saveAll(contacts);
    };
}


}
