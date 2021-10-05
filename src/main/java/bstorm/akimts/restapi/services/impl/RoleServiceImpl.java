package bstorm.akimts.restapi.services.impl;

import bstorm.akimts.restapi.mapper.RoleMapper;
import bstorm.akimts.restapi.models.dto.RoleDTO;
import bstorm.akimts.restapi.models.entity.Role;
import bstorm.akimts.restapi.models.form.RoleForm;
import bstorm.akimts.restapi.repository.RoleRepository;
import bstorm.akimts.restapi.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final RoleMapper mapper;

    public RoleServiceImpl(RoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RoleDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Le role n'existe pas"));
    }

    @Override
    public RoleDTO delete(Long id) {
        Role toDelete = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le role n'existe pas"));

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }

    @Override
    public RoleDTO update(Long id, RoleForm roleForm) {
        Role toUpdate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le role n'existe pas"));

        toUpdate.setNom(roleForm.getNom());

        repository.save(toUpdate);

        return mapper.toDto(toUpdate);
    }

    @Override
    public RoleDTO insert(RoleForm roleForm) {
        Role toInsert = repository.save(mapper.fromFormToEntity(roleForm));

        return mapper.toDto(toInsert);
    }
}
