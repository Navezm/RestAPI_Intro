package bstorm.akimts.restapi.services;

import bstorm.akimts.restapi.models.dto.ProductTypeDTO;
import bstorm.akimts.restapi.models.form.ProductTypeForm;

import java.util.List;

public interface ProductTypeService {

    List<ProductTypeDTO> findAll();

    ProductTypeDTO getOne(Long id);

    ProductTypeDTO delete(Long id);

    ProductTypeDTO update(Long id, ProductTypeForm productTypeForm);

    ProductTypeDTO insert(ProductTypeForm productTypeForm);

}
