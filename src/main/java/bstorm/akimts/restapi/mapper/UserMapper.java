package bstorm.akimts.restapi.mapper;

import bstorm.akimts.restapi.models.dto.UserDTO;
import bstorm.akimts.restapi.models.entity.User;
import bstorm.akimts.restapi.models.form.UserForm;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements BaseMapper<UserDTO, UserForm, User>{
    private final AddressMapper addressMapper = new AddressMapper();

    @Override
    public User toEntity(UserDTO dto) {
        if (dto == null)
            return null;

        return new User(dto.getUsername(),
                        dto.getPassword(),
                        dto.getEmail(),
                        addressMapper.toEntity(dto.getAddress()),
                        dto.getPayType()
        );
    }

    @Override
    public UserDTO toDto(User entity) {
        if (entity == null)
            return null;

        UserDTO userDTO = new UserDTO();

        userDTO.setUsername(entity.getUsername());
        userDTO.setPassword(entity.getPassword());
        userDTO.setEmail(entity.getEmail());
        userDTO.setAddress(addressMapper.toDto(entity.getAddress()));
        userDTO.setPayType(entity.getDefaultPayType());

        return userDTO;
    }

    @Override
    public User fromFormToEntity(UserForm form) {

        if (form == null)
            return null;

        return new User(
                form.getUsername(),
                form.getPassword(),
                form.getEmail(),
                form.getAddressForm(),
                form.getPayType()
        );
    }
}
