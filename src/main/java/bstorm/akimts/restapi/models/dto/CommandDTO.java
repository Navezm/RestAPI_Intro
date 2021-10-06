package bstorm.akimts.restapi.models.dto;

import bstorm.akimts.restapi.models.PayType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class CommandDTO {

    private LocalDate shippingDate;
    private PayType payType;
    private AddressDTO shippingAddress;
    private Set<CommandLineDTO> commandLines;
    private UserDTO user;

}
