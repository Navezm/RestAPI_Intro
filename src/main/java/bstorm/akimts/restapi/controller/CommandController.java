package bstorm.akimts.restapi.controller;

import bstorm.akimts.restapi.models.dto.CommandDTO;
import bstorm.akimts.restapi.models.entity.Command;
import bstorm.akimts.restapi.models.form.CommandForm;
import bstorm.akimts.restapi.services.CommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/command")
public class CommandController {
    private final CommandService service;

    public CommandController(CommandService service) {
        this.service = service;
    }

    @GetMapping({"", "/all"})
    public ResponseEntity<List<CommandDTO>> getAll(){
        List<CommandDTO> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandDTO> getOne(@PathVariable Long id){
        CommandDTO commandDTO = service.getOne(id);

        return ResponseEntity.ok(commandDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<CommandDTO> addCommand(@RequestBody CommandForm commandForm){
        CommandDTO commandDTO = service.insert(commandForm);

        return ResponseEntity.ok(commandDTO);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<CommandDTO> deleteCommand(@PathVariable Long id){
        CommandDTO commandDTO = service.delete(id);

        return ResponseEntity.ok(commandDTO);
    }
}

