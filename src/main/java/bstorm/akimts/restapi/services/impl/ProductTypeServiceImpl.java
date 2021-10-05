package bstorm.akimts.restapi.services.impl;

import bstorm.akimts.restapi.mapper.ProductTypeMapper;
import bstorm.akimts.restapi.models.dto.ProductTypeDTO;
import bstorm.akimts.restapi.models.entity.ProductType;
import bstorm.akimts.restapi.models.form.ProductTypeForm;
import bstorm.akimts.restapi.repository.ProductTypeRepository;
import bstorm.akimts.restapi.services.ProductTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository repository;
    private final ProductTypeMapper mapper;

    public ProductTypeServiceImpl(ProductTypeRepository repository, ProductTypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductTypeDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductTypeDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Le type de produit n'existe pas"));
    }

    @Override
    public ProductTypeDTO delete(Long id) {
        ProductType toDelete = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le type de produit ,n'existe pas"));

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }

    @Override
    public ProductTypeDTO update(Long id, ProductTypeForm productTypeForm) {
        ProductType toUpdate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le type de produit n'existe pas"));

        toUpdate.setName(productTypeForm.getName());

        repository.save(toUpdate);

        return mapper.toDto(toUpdate);
    }

    @Override
    public ProductTypeDTO insert(ProductTypeForm productTypeForm) {
        ProductType toInsert = repository.save(mapper.fromFormToEntity(productTypeForm));

        return mapper.toDto(toInsert);
    }
}
