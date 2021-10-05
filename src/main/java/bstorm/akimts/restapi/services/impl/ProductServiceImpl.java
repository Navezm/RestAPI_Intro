package bstorm.akimts.restapi.services.impl;

import bstorm.akimts.restapi.mapper.ProductMapper;
import bstorm.akimts.restapi.mapper.ProductTypeMapper;
import bstorm.akimts.restapi.models.dto.ProductDTO;
import bstorm.akimts.restapi.models.entity.Product;
import bstorm.akimts.restapi.models.form.ProductForm;
import bstorm.akimts.restapi.repository.ProductRepository;
import bstorm.akimts.restapi.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final ProductTypeMapper productTypeMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, ProductTypeMapper productTypeMapper) {
        this.repository = productRepository;
        this.mapper = productMapper;
        this.productTypeMapper = productTypeMapper;
    }

    @Override
    public List<ProductDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public ProductDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Le produit n'existe pas"));
    }

    @Override
    public ProductDTO delete(Long id) {
        Product toDelete = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le produit n'existe pas"));

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }

    @Override
    public ProductDTO update(Long id, ProductForm productForm) {
        Product toUpdate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le produit n'existe pas"));

        toUpdate.setName(productForm.getName());
        toUpdate.setType(productTypeMapper.fromFormToEntity(productForm.getType()));

        repository.save(toUpdate);

        return mapper.toDto(toUpdate);
    }

    @Override
    public ProductDTO insert(ProductForm productForm) {
        Product toInsert = repository.save(mapper.fromFormToEntity(productForm));

        return mapper.toDto(toInsert);
    }
}
