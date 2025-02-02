package plantaagua.plantaagua;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import plantaagua.plantaagua.Tipecontacts.entity.TipeContacts;
import plantaagua.plantaagua.Tipecontacts.repository.TipeContactsRepository;
import plantaagua.plantaagua.contacts.entity.Contact;
import plantaagua.plantaagua.contacts.repository.ContactRepository;
import plantaagua.plantaagua.productos.entity.Porducto;
import plantaagua.plantaagua.productos.repository.ProductRepository;
import plantaagua.plantaagua.store.entity.Store;
import plantaagua.plantaagua.store.repository.StoreRepository;
import plantaagua.plantaagua.tipeStore.entity.TipeStore;
import plantaagua.plantaagua.tipeStore.repository.TipeStoreRepository;
import plantaagua.plantaagua.tipoProducto.entity.TipeProducts;
import plantaagua.plantaagua.tipoProducto.infraestructure.repository.TipeProductsRepository;

@SpringBootApplication
public class PlantaaguaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantaaguaApplication.class, args);
    }

    @Bean
CommandLineRunner contactRunner(ContactRepository contactRepository, TipeContactsRepository tipeContactsRepository) {
    return args -> {
        // Inicializamos tipos de contacto
        TipeContacts tipeContact1 = new TipeContacts( "Cliente");
        TipeContacts tipeContact2 = new TipeContacts( "Proveedor");
        tipeContactsRepository.saveAll(Arrays.asList(tipeContact1, tipeContact2));

        // Inicializamos contactos
        List<Contact> contacts = Arrays.asList(
            new Contact("Carlos", "carlos@gmail.com", "Gerente", "Ninguna", "123456789", LocalDateTime.now(), tipeContact1),
            new Contact("Juan", "juan@gmail.com", "Analista", "Requiere seguimiento", "987654321", LocalDateTime.now(), tipeContact2),
            new Contact("Marcelo", "marcelo@gmail.com", "Director", "Pendiente de reunión", "111222333", LocalDateTime.now(), tipeContact1),
            new Contact("Luis", "luis@gmail.com", "Supervisor", "Comentarios adicionales", "444555666", LocalDateTime.now(), tipeContact2)
        );

        contactRepository.saveAll(contacts);
    };
}


    @Bean
    CommandLineRunner tipeProductsRunner(TipeProductsRepository tipeProductsRepository) {
        return args -> {
            List<TipeProducts> tipeProducts = Arrays.asList(
                new TipeProducts("Botellon Vacio"),
                new TipeProducts("Botellon Recargado 50 litros")
            );
            tipeProductsRepository.saveAll(tipeProducts);
        };
    }

   @Bean
    CommandLineRunner productoRunner(ProductRepository productoRepository, TipeProductsRepository tipeProductsRepository) {
        return args -> {
            // Convertir Iterable<TipeProducts> a List<TipeProducts> usando ArrayList
            List<TipeProducts> tipeProducts = new ArrayList<>();
            tipeProductsRepository.findAll().forEach(tipeProducts::add);

            // if (tipeProducts.isEmpty()) {
            //     System.out.println("No hay tipos de productos disponibles. Por favor, inicializa los tipos primero.");
            //     return;
            // }

            // Crear productos asociados a los tipos de productos
            List<Porducto> productos = Arrays.asList(
                new Porducto("Agua Mineral", "Botella de 500ml de agua mineral", "1.50", tipeProducts.get(0)),
                new Porducto("Agua Gasificada", "Botella de 1 litro de agua con gas", "2.00", tipeProducts.get(1))
            );

            // Guardar los productos en la base de datos
            productoRepository.saveAll(productos);

            System.out.println("Productos inicializados exitosamente.");
        };
    }

    // @Bean
    // CommandLineRunner storeRunner(StoreRepository storeRepository, TipeStoreRepository tipeStoreRepository, ContactRepository contactRepository){
    //     return args -> {

    //         List<TipeStore> tipeStores = new ArrayList<>();
    //         tipeStoreRepository.findAll().forEach(tipeStores::add);

    //         List<customerContact> contacts = new ArrayList<>();
    //         contactRepository.findAll().forEach(contacts::add);

    //         List<Store> stores = Arrays.asList(
    //             new Store("Reparto", "Casa Inge", "3235656562", tipeStores.get(0), contacts.get(1)),
    //             new Store("Produccion", " Call 20 - 30", "3132634562", tipeStores.get(1), contacts.get(2))
    //         );

    //         storeRepository.saveAll(stores);

            

    //     };
    // }



    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
