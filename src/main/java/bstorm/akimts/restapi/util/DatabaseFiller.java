package bstorm.akimts.restapi.util;

import bstorm.akimts.restapi.models.PayType;
import bstorm.akimts.restapi.models.entity.*;
import bstorm.akimts.restapi.repository.ProductRepository;
import bstorm.akimts.restapi.repository.UserRepository;
import bstorm.akimts.restapi.repository.VoitureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseFiller implements InitializingBean {

    private final Logger log = LoggerFactory.getLogger(DatabaseFiller.class);
    private final VoitureRepository repository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public DatabaseFiller(VoitureRepository repository, UserRepository userRepository, ProductRepository productRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("hydratation de la DB");

//        List<Voiture> toInsert = List.of(
//                new Voiture(0, "VrimVroom", "BipBoop", 120),
//                new Voiture(0, "VrimVroom", "BipBoop-Mini", 80),
//                new Voiture(0, "VrimVroom", "BipBoop Sprot", 180),
//                new Voiture(0, "VrimVroom", "BipBoop-LuX", 200),
//                new Voiture(0, "VrimVroom", "Breeh", 90),
//                new Voiture(0, "VrimVroom", "Breeh 2", 110),
//                new Voiture(0, "VrimVroom", "Breeh 2 Sprot", 150),
//                new Voiture(0, "VrimVroom", "BipBoop 3", 100),
//                new Voiture(0, "VrimVroom", "BipBoop 3 sw", 110),
//                new Voiture(0, "VrimVroom", "BipBoop 4", 120)
//        );

        List<User> userToInsert = List.of(
                new User("martin", "123456", "n@n", new Address("rue machin", "105", "Bx", "BE"), PayType.BANCONTACT),
                new User("Laetitia", "123456", "l@l", new Address("rue truc", "125", "Bx", "BE"), PayType.CASH),
                new User("Arnaud", "123456", "a@a", new Address("rue bidule", "2", "Bx", "BE"), PayType.PAYPAL)
        );

        List<Product> productToInsert = List.of(
                new Product("Casquette", new ProductType("Vetement")),
                new Product("Mug", new ProductType("Vaiselle")),
                new Product("Assiette", new ProductType("Vaiselle")),
                new Product("T-Shirt", new ProductType("Vetement"))
        );

//        repository.saveAll(toInsert);

//        productRepository.saveAll(productToInsert);

        userRepository.saveAll(userToInsert);

    }
}
