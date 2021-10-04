package bstorm.akimts.restapi.mapper;

import bstorm.akimts.restapi.models.dto.AddressDTO;
import bstorm.akimts.restapi.models.entity.Address;
import bstorm.akimts.restapi.models.form.AddressForm;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper implements BaseMapper<AddressDTO, AddressForm, Address>{
    @Override
    public Address toEntity(AddressDTO dto) {
        if (dto == null)
            return null;

        return new Address(
                dto.getStreet(),
                dto.getStreetNumber(),
                dto.getCity(),
                dto.getCountry()
        );
    }

    @Override
    public AddressDTO toDto(Address entity) {

        if (entity == null)
            return null;

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setStreet(entity.getStreet());
        addressDTO.setStreetNumber(entity.getStreetNumber());
        addressDTO.setCity(entity.getCity());
        addressDTO.setCountry(entity.getCountry());

        return addressDTO;
    }

    @Override
    public Address fromFormToEntity(AddressForm form) {

        if (form == null)
            return null;

        Address address = new Address();

        address.setStreet(form.getStreet());
        address.setStreetNumber(form.getStreetNumber());
        address.setCity(form.getCity());
        address.setCountry(form.getCountry());

        return address;
    }
}
