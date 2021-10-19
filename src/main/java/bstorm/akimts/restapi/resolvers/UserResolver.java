package bstorm.akimts.restapi.resolvers;

import bstorm.akimts.restapi.models.PayType;
import bstorm.akimts.restapi.models.entity.Address;
import bstorm.akimts.restapi.models.entity.User;
import bstorm.akimts.restapi.services.AddressService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class UserResolver implements GraphQLResolver<User> {

    public Address getAddress(User user) { return user.getAddress(); }
    public PayType getPayType(User user) { return user.getDefaultPayType(); }

}
