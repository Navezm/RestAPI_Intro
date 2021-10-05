package bstorm.akimts.restapi.mapper;

import bstorm.akimts.restapi.models.dto.RoleDTO;
import bstorm.akimts.restapi.models.entity.Role;
import bstorm.akimts.restapi.models.form.RoleForm;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper implements BaseMapper<RoleDTO, RoleForm, Role> {
    @Override
    public Role toEntity(RoleDTO dto) {
        if (dto == null)
            return null;

        return new Role(dto.getName());
    }

    @Override
    public RoleDTO toDto(Role entity) {
        if (entity == null)
            return null;

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setName(entity.getNom());

        return roleDTO;
    }

    @Override
    public Role fromFormToEntity(RoleForm form) {
        if (form == null)
            return null;

        return new Role(form.getNom());
    }
}
