package bstorm.akimts.restapi.controller;

import bstorm.akimts.restapi.models.dto.UserDTO;
import bstorm.akimts.restapi.models.entity.User;
import bstorm.akimts.restapi.models.form.UserForm;
import bstorm.akimts.restapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<UserDTO> userDTOList = userService.findAll();

        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getOne(@PathVariable Long id){

        UserDTO userDTO = userService.getOne(id);

        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserForm form){

        UserDTO userDTO = userService.insert(form);

        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){

        UserDTO userDTO = userService.delete(id);

        return ResponseEntity.ok(userDTO);
    }
}
