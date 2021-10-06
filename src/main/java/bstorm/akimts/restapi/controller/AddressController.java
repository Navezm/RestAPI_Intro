package bstorm.akimts.restapi.controller;

import bstorm.akimts.restapi.models.dto.AddressDTO;
import bstorm.akimts.restapi.models.form.AddressForm;
import bstorm.akimts.restapi.services.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping({"", "/all"})
    public ResponseEntity<List<AddressDTO>> getAll(){
        List<AddressDTO> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getOne(@PathVariable Long id){
        AddressDTO addressDTO = service.getOne(id);

        return ResponseEntity.ok(addressDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressForm addressForm){
        AddressDTO addressDTO = service.insert(addressForm);

        return ResponseEntity.ok(addressDTO);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<AddressDTO> deleteAddress(@PathVariable Long id){
        AddressDTO addressDTO = service.delete(id);

        return ResponseEntity.ok(addressDTO);
    }
}
