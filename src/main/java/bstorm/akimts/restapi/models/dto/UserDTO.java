package bstorm.akimts.restapi.models.dto;

import bstorm.akimts.restapi.models.PayType;
import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;
    private String password;
    private String email;
    private AddressDTO address;
    private PayType payType;

}
