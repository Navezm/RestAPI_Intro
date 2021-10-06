package bstorm.akimts.restapi.controller;

import bstorm.akimts.restapi.models.dto.ProductTypeDTO;
import bstorm.akimts.restapi.models.form.ProductTypeForm;
import bstorm.akimts.restapi.services.ProductTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productType")
public class ProductTypeController {
    private final ProductTypeService service;

    public ProductTypeController(ProductTypeService service) {
        this.service = service;
    }

    @GetMapping({"", "/all"})
    public ResponseEntity<List<ProductTypeDTO>> getAll(){

        List<ProductTypeDTO> productTypeDTOList = service.findAll();

        return ResponseEntity.ok(productTypeDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeDTO> getOne(@PathVariable Long id){

        ProductTypeDTO productTypeDTO = service.getOne(id);

        return ResponseEntity.ok(productTypeDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductTypeDTO> add(@RequestBody ProductTypeForm productTypeForm){

        ProductTypeDTO productTypeDTO = service.insert(productTypeForm);

        return ResponseEntity.ok(productTypeDTO);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<ProductTypeDTO> delete(@PathVariable Long id){

        ProductTypeDTO productTypeDTO = service.delete(id);

        return ResponseEntity.ok(productTypeDTO);
    }

}
