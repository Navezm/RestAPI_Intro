package bstorm.akimts.restapi.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class AddressDTO {

    private String street;
    private String streetNumber;
    private String city;
    private String country = "BE";

}
