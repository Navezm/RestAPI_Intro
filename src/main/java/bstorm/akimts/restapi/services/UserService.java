package bstorm.akimts.restapi.services;

import bstorm.akimts.restapi.models.dto.UserDTO;
import bstorm.akimts.restapi.models.form.UserForm;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO getOne(Long id);

    UserDTO delete(Long id);

    UserDTO update(Long id, UserForm userForm);

    UserDTO insert(UserForm form);

}
