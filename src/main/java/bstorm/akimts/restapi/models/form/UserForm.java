package bstorm.akimts.restapi.models.form;

import bstorm.akimts.restapi.models.PayType;
import bstorm.akimts.restapi.models.entity.Address;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Validated
public class UserForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    private Address addressForm;
    private PayType payType;

}
