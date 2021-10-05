package bstorm.akimts.restapi.services.impl;

import bstorm.akimts.restapi.mapper.AddressMapper;
import bstorm.akimts.restapi.models.dto.AddressDTO;
import bstorm.akimts.restapi.models.entity.Address;
import bstorm.akimts.restapi.models.form.AddressForm;
import bstorm.akimts.restapi.repository.AddressRepository;
import bstorm.akimts.restapi.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    public AddressServiceImpl(AddressRepository repository, AddressMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<AddressDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("L'adresse n'existe pas"));
    }

    @Override
    public AddressDTO delete(Long id) {
        Address toDelete = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("L'addresse n'existe pas"));

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }

    @Override
    public AddressDTO update(Long id, AddressForm addressForm) {
        Address toUpdate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("L'adresse n'existe pas"));

        toUpdate.setStreet(addressForm.getStreet());
        toUpdate.setStreetNumber(addressForm.getStreetNumber());
        toUpdate.setCity(addressForm.getCity());
        toUpdate.setCountry(addressForm.getCountry());

        repository.save(toUpdate);

        return mapper.toDto(toUpdate);
    }

    @Override
    public AddressDTO insert(AddressForm addressForm) {
        Address toInsert = mapper.fromFormToEntity(addressForm);

        repository.save(toInsert);

        return mapper.toDto(toInsert);
    }
}
