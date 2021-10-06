package bstorm.akimts.restapi.controller;

import bstorm.akimts.restapi.models.dto.CommandLineDTO;
import bstorm.akimts.restapi.models.form.CommandLineForm;
import bstorm.akimts.restapi.services.CommandLineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandLine")
public class CommandLineController {
    private final CommandLineService service;

    public CommandLineController(CommandLineService service) {
        this.service = service;
    }

    @GetMapping({"", "/all"})
    public ResponseEntity<List<CommandLineDTO>> getAll(){
        List<CommandLineDTO> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandLineDTO> getOne(@PathVariable Long id){
        CommandLineDTO commandLineDTO = service.getOne(id);

        return ResponseEntity.ok(commandLineDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<CommandLineDTO> addCommandLine(@RequestBody CommandLineForm commandLineForm){
        CommandLineDTO commandLineDTO = service.insert(commandLineForm);

        return ResponseEntity.ok(commandLineDTO);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<CommandLineDTO> deleteCommandLine(@PathVariable Long id){
        CommandLineDTO commandLineDTO = service.delete(id);

        return ResponseEntity.ok(commandLineDTO);
    }
}
