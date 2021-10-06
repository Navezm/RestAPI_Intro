package bstorm.akimts.restapi.services.impl;

import bstorm.akimts.restapi.mapper.GroupMapper;
import bstorm.akimts.restapi.mapper.RoleMapper;
import bstorm.akimts.restapi.models.dto.GroupDTO;
import bstorm.akimts.restapi.models.entity.Group;
import bstorm.akimts.restapi.models.form.GroupForm;
import bstorm.akimts.restapi.repository.GroupRepository;
import bstorm.akimts.restapi.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository repository;
    private final GroupMapper mapper;
    private final RoleMapper roleMapper;

    public GroupServiceImpl(GroupRepository repository, GroupMapper mapper, RoleMapper roleMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<GroupDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public GroupDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Le groupe n'existe pas"));
    }

    @Override
    public GroupDTO delete(Long id) {
        Group toDelete = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le groupe n'existe pas"));

        repository.delete(toDelete);

        return mapper.toDto(toDelete);
    }

    @Override
    public GroupDTO update(Long id, GroupForm groupForm) {
        Group toUpdate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le groupe n'existe pas"));

        toUpdate.setName(groupForm.getName());
        toUpdate.setRoles(groupForm.getRoles()
                .stream()
                .map(roleMapper::fromFormToEntity)
                .collect(Collectors.toSet())
        );

        return mapper.toDto(toUpdate);
    }

    @Override
    public GroupDTO insert(GroupForm groupForm) {
        Group toInsert = mapper.fromFormToEntity(groupForm);

        repository.save(toInsert);

        return mapper.toDto(toInsert);
    }
}
