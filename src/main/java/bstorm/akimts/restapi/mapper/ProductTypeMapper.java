package bstorm.akimts.restapi.mapper;

import bstorm.akimts.restapi.models.dto.ProductDTO;
import bstorm.akimts.restapi.models.dto.ProductTypeDTO;
import bstorm.akimts.restapi.models.entity.ProductType;
import bstorm.akimts.restapi.models.form.ProductTypeForm;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeMapper implements BaseMapper<ProductTypeDTO, ProductTypeForm, ProductType> {

    @Override
    public ProductType toEntity(ProductTypeDTO dto) {

        if (dto == null)
            return null;

        return new ProductType(dto.getName());
    }

    @Override
    public ProductTypeDTO toDto(ProductType entity) {

        if (entity == null)
            return null;

        ProductTypeDTO productTypeDTO = new ProductTypeDTO();

        productTypeDTO.setName(entity.getName());

        return productTypeDTO;
    }

    @Override
    public ProductType fromFormToEntity(ProductTypeForm form) {

        if (form == null)
            return null;

        return new ProductType(form.getName());
    }
}
