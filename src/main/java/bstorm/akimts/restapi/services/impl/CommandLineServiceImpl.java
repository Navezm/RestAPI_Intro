package bstorm.akimts.restapi.services.impl;

import bstorm.akimts.restapi.mapper.CommandLineMapper;
import bstorm.akimts.restapi.models.dto.CommandLineDTO;
import bstorm.akimts.restapi.models.entity.CommandLine;
import bstorm.akimts.restapi.models.form.CommandLineForm;
import bstorm.akimts.restapi.repository.CommandLineRepository;
import bstorm.akimts.restapi.services.CommandLineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandLineServiceImpl implements CommandLineService {
    private final CommandLineRepository repository;
    private final CommandLineMapper mapper;

    public CommandLineServiceImpl(CommandLineRepository repository, CommandLineMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CommandLineDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommandLineDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("La ligne de commande n'existe pas"));
    }

    @Override
    public CommandLineDTO delete(Long id) {
        CommandLine toDelete = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La ligne de commande n'existe pas"));

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }

    @Override
    public CommandLineDTO update(Long id, CommandLineForm commandLineForm) {
        CommandLine toUpdate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La ligne de commande n'existe pas"));

        toUpdate.setCommandId(commandLineForm.getCommandId());
        toUpdate.setProduct(commandLineForm.getProduct());
        toUpdate.setProductId(commandLineForm.getProductId());
        toUpdate.setQtt(commandLineForm.getQtt());

        return mapper.toDto(repository.save(toUpdate));
    }

    @Override
    public CommandLineDTO insert(CommandLineForm commandLineForm) {
        return mapper.toDto(repository.save(mapper.fromFormToEntity(commandLineForm)));
    }
}
