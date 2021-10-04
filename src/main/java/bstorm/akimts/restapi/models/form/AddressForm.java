package bstorm.akimts.restapi.models.form;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.bind.DefaultValue;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class AddressForm {

    private String street;
    private String streetNumber;
    private String city;
    private String country;

}
