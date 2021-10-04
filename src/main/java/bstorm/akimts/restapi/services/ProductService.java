package bstorm.akimts.restapi.services;

import bstorm.akimts.restapi.models.dto.ProductDTO;
import bstorm.akimts.restapi.models.form.ProductForm;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    ProductDTO getOne(Long id);

    ProductDTO delete(Long id);

    ProductDTO update(Long id, ProductForm productForm);

    ProductDTO insert(ProductForm productForm);
}
