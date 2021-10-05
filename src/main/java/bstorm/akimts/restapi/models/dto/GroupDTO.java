package bstorm.akimts.restapi.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GroupDTO {

    private String name;
    private Set<RoleDTO> roles;

}
