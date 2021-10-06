package bstorm.akimts.restapi.services.impl;

import bstorm.akimts.restapi.mapper.CommandMapper;
import bstorm.akimts.restapi.models.dto.CommandDTO;
import bstorm.akimts.restapi.models.entity.Command;
import bstorm.akimts.restapi.models.form.CommandForm;
import bstorm.akimts.restapi.repository.CommandRepository;
import bstorm.akimts.restapi.services.CommandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandServiceImpl implements CommandService {
    private final CommandRepository repository;
    private final CommandMapper mapper;

    public CommandServiceImpl(CommandRepository repository, CommandMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CommandDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommandDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("La commande n'existe pas"));
    }

    @Override
    public CommandDTO delete(Long id) {
        Command toDelete = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La commande n'existe pas"));

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }

    @Override
    public CommandDTO update(Long id, CommandForm commandForm) {
        Command toUpdate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La commande n'existe pas"));

        toUpdate.setCommandLines(commandForm.getCommandLines());
        toUpdate.setPayType(commandForm.getPayType());
        toUpdate.setShippingAddress(commandForm.getShippingAddress());
        toUpdate.setUser(commandForm.getUser());
        toUpdate.setShippingDate(commandForm.getShippingDate());

        return mapper.toDto(repository.save(toUpdate));
    }

    @Override
    public CommandDTO insert(CommandForm commandForm) {
        return mapper.toDto(repository.save(mapper.fromFormToEntity(commandForm)));
    }
}
