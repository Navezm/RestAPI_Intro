package bstorm.akimts.restapi.queries;

import bstorm.akimts.restapi.mapper.UserMapper;
import bstorm.akimts.restapi.models.entity.User;
import bstorm.akimts.restapi.services.UserService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserQueryResolver(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public List<User> getUsers() { return this.userService.findAll().stream()
            .map(userMapper::toEntity)
            .collect(Collectors.toList()); }


}
