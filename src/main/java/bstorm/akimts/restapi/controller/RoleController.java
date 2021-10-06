package bstorm.akimts.restapi.controller;

import bstorm.akimts.restapi.models.dto.RoleDTO;
import bstorm.akimts.restapi.models.entity.Role;
import bstorm.akimts.restapi.models.form.RoleForm;
import bstorm.akimts.restapi.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping({"", "/all"})
    public ResponseEntity<List<RoleDTO>> getAll(){
        List<RoleDTO> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getOne(@PathVariable Long id){
        RoleDTO roleDTO = service.getOne(id);

        return ResponseEntity.ok(roleDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<RoleDTO> addRole(@RequestBody RoleForm roleForm){
        RoleDTO roleDTO = service.insert(roleForm);

        return ResponseEntity.ok(roleDTO);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<RoleDTO> deleteRole(@PathVariable Long id){
        RoleDTO roleDTO = service.delete(id);

        return ResponseEntity.ok(roleDTO);
    }
}
