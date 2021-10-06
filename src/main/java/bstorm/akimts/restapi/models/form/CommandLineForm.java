package bstorm.akimts.restapi.models.form;

import bstorm.akimts.restapi.models.entity.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class CommandLineForm {

    private Long commandId;
    private Long productId;
    private Product product;
    private float qtt;

}
