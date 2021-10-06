package bstorm.akimts.restapi.models.form;

import bstorm.akimts.restapi.models.dto.RoleDTO;
import bstorm.akimts.restapi.models.entity.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class GroupForm {

    private String name;
    private Set<Role> roles;

}
