package bstorm.akimts.restapi.mapper;

import bstorm.akimts.restapi.models.dto.ProductDTO;
import bstorm.akimts.restapi.models.entity.Product;
import bstorm.akimts.restapi.models.form.ProductForm;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper implements BaseMapper<ProductDTO, ProductForm, Product> {
    private final ProductTypeMapper productTypeMapper;


    public ProductMapper(ProductTypeMapper productTypeMapper) {
        this.productTypeMapper = productTypeMapper;
    }


    @Override
    public Product toEntity(ProductDTO dto) {

        if (dto == null)
            return null;

        return new Product(dto.getName(), productTypeMapper.toEntity(dto.getType()));
    }

    @Override
    public ProductDTO toDto(Product entity) {
        if (entity == null)
            return null;

        ProductDTO productDTO = new ProductDTO();

        productDTO.setName(entity.getName());
        productDTO.setType(productTypeMapper.toDto(entity.getType()));

        return productDTO;
    }

    @Override
    public Product fromFormToEntity(ProductForm form) {
        if (form == null)
            return null;

        return new Product(
                form.getName(),
                productTypeMapper.fromFormToEntity(form.getType())
        );
    }
}
