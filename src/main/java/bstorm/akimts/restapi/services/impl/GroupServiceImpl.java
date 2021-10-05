package bstorm.akimts.restapi.services.impl;

import bstorm.akimts.restapi.mapper.GroupMapper;
import bstorm.akimts.restapi.models.dto.GroupDTO;
import bstorm.akimts.restapi.models.form.GroupForm;
import bstorm.akimts.restapi.repository.GroupRepository;
import bstorm.akimts.restapi.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository repository;
    private final GroupMapper mapper;

    public GroupServiceImpl(GroupRepository repository, GroupMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<GroupDTO> findAll() {
        return null;
    }

    @Override
    public GroupDTO getOne(Long id) {
        return null;
    }

    @Override
    public GroupDTO delete(Long id) {
        return null;
    }

    @Override
    public GroupDTO update(Long id, GroupForm groupForm) {
        return null;
    }

    @Override
    public GroupDTO insert(GroupForm groupForm) {
        return null;
    }
}
