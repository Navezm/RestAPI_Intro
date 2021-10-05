package bstorm.akimts.restapi.services;

import bstorm.akimts.restapi.models.dto.RoleDTO;
import bstorm.akimts.restapi.models.entity.Role;
import bstorm.akimts.restapi.models.form.RoleForm;

import java.util.List;

public interface RoleService {

    List<RoleDTO> findAll();

    RoleDTO getOne(Long id);

    RoleDTO delete(Long id);

    RoleDTO update(Long id, RoleForm roleForm);

    RoleDTO insert(RoleForm roleForm);
}
