package bstorm.akimts.restapi.services.impl;

import bstorm.akimts.restapi.mapper.CommandMapper;
import bstorm.akimts.restapi.models.dto.CommandDTO;
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
        return null;
    }

    @Override
    public CommandDTO delete(Long id) {
        return null;
    }

    @Override
    public CommandDTO update(Long id, CommandForm commandForm) {
        return null;
    }

    @Override
    public CommandDTO insert(CommandForm commandForm) {
        return null;
    }
}
