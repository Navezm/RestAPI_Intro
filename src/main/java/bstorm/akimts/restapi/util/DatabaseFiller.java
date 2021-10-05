package bstorm.akimts.restapi.util;

import bstorm.akimts.restapi.models.PayType;
import bstorm.akimts.restapi.models.entity.*;
import bstorm.akimts.restapi.repository.AddressRepository;
import bstorm.akimts.restapi.repository.ProductRepository;
import bstorm.akimts.restapi.repository.ProductTypeRepository;
import bstorm.akimts.restapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseFiller implements InitializingBean {

    private final Logger log = LoggerFactory.getLogger(DatabaseFiller.class);
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final AddressRepository addressRepository;

    public DatabaseFiller(UserRepository userRepository, ProductRepository productRepository, ProductTypeRepository productTypeRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("hydratation de la DB");

        List<Address> addressToInsert = List.of(
                new Address("rue machin", "105", "Bx", "BE"),
                new Address("rue truc", "125", "Etterbeek", "BE"),
                new Address("rue bidule", "256", "Woluwe-Saint-Lambert", "BE")
        );

        List<User> userToInsert = List.of(
                new User("martin", "123456", "n@n", addressToInsert.get(0), PayType.BANCONTACT),
                new User("Laetitia", "123456", "l@l", addressToInsert.get(1), PayType.CASH),
                new User("Arnaud", "123456", "a@a", addressToInsert.get(2), PayType.PAYPAL)
        );

        List<ProductType> productTypeToInsert = List.of(
                new ProductType("Vêtement"),
                new ProductType("Vaiselle"),
                new ProductType("Meuble"),
                new ProductType("Nourriture")
        );

        List<Product> productToInsert = List.of(
                new Product("Casquette", productTypeToInsert.get(0)),
                new Product("Mug", productTypeToInsert.get(1)),
                new Product("Assiette", productTypeToInsert.get(0)),
                new Product("T-Shirt", productTypeToInsert.get(1)),
                new Product("Céréales", productTypeToInsert.get(3)),
                new Product("Commode", productTypeToInsert.get(2))
        );

        productTypeRepository.saveAll(productTypeToInsert);

        addressRepository.saveAll(addressToInsert);

        userRepository.saveAll(userToInsert);

        productRepository.saveAll(productToInsert);
    }
}
