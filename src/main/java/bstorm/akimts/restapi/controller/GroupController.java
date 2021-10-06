package bstorm.akimts.restapi.controller;

import bstorm.akimts.restapi.models.dto.GroupDTO;
import bstorm.akimts.restapi.models.form.GroupForm;
import bstorm.akimts.restapi.services.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @GetMapping({"", "/all"})
    public ResponseEntity<List<GroupDTO>> getAll(){
        List<GroupDTO> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getOne(@PathVariable Long id){
        GroupDTO groupDTO = service.getOne(id);

        return ResponseEntity.ok(groupDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<GroupDTO> addGroup(@RequestBody GroupForm groupForm){
        GroupDTO groupDTO = service.insert(groupForm);

        return ResponseEntity.ok(groupDTO);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<GroupDTO> deleteGroup(@PathVariable Long id){
        GroupDTO groupDTO = service.delete(id);

        return ResponseEntity.ok(groupDTO);
    }

}
