package bstorm.akimts.restapi.services;

import bstorm.akimts.restapi.models.dto.AddressDTO;
import bstorm.akimts.restapi.models.form.AddressForm;

import java.util.List;

public interface AddressService {
    List<AddressDTO> findAll();

    AddressDTO getOne(Long id);

    AddressDTO delete(Long id);

    AddressDTO update(Long id, AddressForm addressForm);

    AddressDTO insert(AddressForm addressForm);
}
