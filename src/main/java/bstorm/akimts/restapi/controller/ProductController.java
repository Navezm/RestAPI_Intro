package bstorm.akimts.restapi.controller;

import bstorm.akimts.restapi.models.dto.ProductDTO;
import bstorm.akimts.restapi.models.form.ProductForm;
import bstorm.akimts.restapi.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping({"", "/all"})
    public ResponseEntity<List<ProductDTO>> getAll(){
        List<ProductDTO> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getOne(@PathVariable Long id){
        ProductDTO productDTO = service.getOne(id);

        return ResponseEntity.ok(productDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductForm productForm){

        ProductDTO productDTO = service.insert(productForm);

        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long id){

        ProductDTO productDTO = service.delete(id);

        return ResponseEntity.ok(productDTO);

    }
}
