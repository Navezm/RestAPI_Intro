package bstorm.akimts.restapi.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class ProductDTO {

    private String name;
    private ProductTypeDTO type;

}
