package bstorm.akimts.restapi.services;

import bstorm.akimts.restapi.models.dto.GroupDTO;
import bstorm.akimts.restapi.models.form.GroupForm;

import java.util.List;

public interface GroupService {
    List<GroupDTO> findAll();

    GroupDTO getOne(Long id);

    GroupDTO delete(Long id);

    GroupDTO update(Long id, GroupForm groupForm);

    GroupDTO insert(GroupForm groupForm);
}
