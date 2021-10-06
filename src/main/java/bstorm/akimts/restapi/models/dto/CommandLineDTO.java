package bstorm.akimts.restapi.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class CommandLineDTO {

    private Long commandId;
    private Long productId;
    private ProductDTO product;
    private float qtt;

}
