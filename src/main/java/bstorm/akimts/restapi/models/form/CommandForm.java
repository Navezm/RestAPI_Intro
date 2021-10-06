package bstorm.akimts.restapi.models.form;

import bstorm.akimts.restapi.models.PayType;
import bstorm.akimts.restapi.models.entity.Address;
import bstorm.akimts.restapi.models.entity.CommandLine;
import bstorm.akimts.restapi.models.entity.User;
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
public class CommandForm {

    private LocalDate shippingDate;
    private PayType payType;
    private Address shippingAddress;
    private Set<CommandLine> commandLines;
    private User user;

}
