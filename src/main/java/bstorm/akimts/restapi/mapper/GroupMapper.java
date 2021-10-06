package bstorm.akimts.restapi.mapper;

import bstorm.akimts.restapi.models.dto.GroupDTO;
import bstorm.akimts.restapi.models.entity.Group;
import bstorm.akimts.restapi.models.form.GroupForm;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GroupMapper implements BaseMapper<GroupDTO, GroupForm, Group>{
    private final RoleMapper roleMapper;

    public GroupMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public Group toEntity(GroupDTO dto) {
        if (dto == null)
            return null;

        return new Group(
                dto.getName(),
                dto.getRoles()
                        .stream()
                        .map(roleMapper::toEntity)
                        .collect(Collectors.toSet())
        );
    }

    @Override
    public GroupDTO toDto(Group entity) {
        if (entity == null)
            return null;

        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setName(entity.getName());
        groupDTO.setRoles(
                entity.getRoles()
                        .stream()
                        .map(roleMapper::toDto)
                        .collect(Collectors.toSet())
        );

        return groupDTO;
    }

    @Override
    public Group fromFormToEntity(GroupForm form) {
        if (form == null)
            return null;

        return new Group(
                form.getName(),
                form.getRoles()
        );
    }
}
