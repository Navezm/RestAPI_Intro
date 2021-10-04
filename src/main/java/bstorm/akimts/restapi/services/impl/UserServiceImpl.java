package bstorm.akimts.restapi.services.impl;

import bstorm.akimts.restapi.mapper.AddressMapper;
import bstorm.akimts.restapi.mapper.UserMapper;
import bstorm.akimts.restapi.models.dto.UserDTO;
import bstorm.akimts.restapi.models.entity.User;
import bstorm.akimts.restapi.models.form.UserForm;
import bstorm.akimts.restapi.repository.UserRepository;
import bstorm.akimts.restapi.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final AddressMapper addressMapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper, AddressMapper addressMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.addressMapper = addressMapper;
    }


    @Override
    public List<UserDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Le User n'existe pas"));
    }

    @Override
    public UserDTO delete(Long id) {

        User toDelete = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le User n'existe pas"));

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }

    @Override
    public UserDTO update(Long id, UserForm userForm) {

        User toUpdate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le User n'existe pas"));

        toUpdate.setUsername(userForm.getUsername());
        toUpdate.setPassword(userForm.getPassword());
        toUpdate.setEmail(userForm.getEmail());
        toUpdate.setAddress(addressMapper.fromFormToEntity(userForm.getAddressForm()));
        toUpdate.setDefaultPayType(userForm.getPayType());

        repository.save(toUpdate);

        return mapper.toDto(toUpdate);
    }

    @Override
    public UserDTO insert(UserForm form) {
        repository.save(mapper.fromFormToEntity(form));

        return mapper.toDto(mapper.fromFormToEntity(form));
    }
}
