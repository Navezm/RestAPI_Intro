package bstorm.akimts.restapi.util;

import bstorm.akimts.restapi.models.PayType;
import bstorm.akimts.restapi.models.entity.*;
import bstorm.akimts.restapi.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Component
public class DatabaseFiller implements InitializingBean {

    private final Logger log = LoggerFactory.getLogger(DatabaseFiller.class);
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;
    private final GroupRepository groupRepository;
    private final CommandLineRepository commandLineRepository;
    private final CommandRepository commandRepository;

    public DatabaseFiller(UserRepository userRepository, ProductRepository productRepository, ProductTypeRepository productTypeRepository, AddressRepository addressRepository, RoleRepository roleRepository, GroupRepository groupRepository, CommandLineRepository commandLineRepository, CommandRepository commandRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.addressRepository = addressRepository;
        this.roleRepository = roleRepository;
        this.groupRepository = groupRepository;
        this.commandLineRepository = commandLineRepository;
        this.commandRepository = commandRepository;
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

        List<Role> roleToInsert = List.of(
                new Role("User"),
                new Role("Admin")
        );

        Group groupToInsert = new Group("Base Group", new HashSet<>(roleToInsert));

        List<CommandLine> commandLinesToInsert = List.of(
                new CommandLine(1L, 2L, productToInsert.get(1), 2.0F),
                new CommandLine(2L, 1L, productToInsert.get(0), 10.0F),
                new CommandLine(3L, 3L, productToInsert.get(2), 5.0F)
        );

        Command commandToInsert = new Command(
                LocalDate.now(),
                PayType.VISA,
                addressToInsert.get(0),
                new HashSet<>(commandLinesToInsert),
                userToInsert.get(0)
        );

        roleRepository.saveAll(roleToInsert);

        groupRepository.save(groupToInsert);

        productTypeRepository.saveAll(productTypeToInsert);

        addressRepository.saveAll(addressToInsert);

        userRepository.saveAll(userToInsert);

        productRepository.saveAll(productToInsert);

        commandLineRepository.saveAll(commandLinesToInsert);

        commandRepository.save(commandToInsert);
    }
}
