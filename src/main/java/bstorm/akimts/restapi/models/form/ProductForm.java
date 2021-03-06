package bstorm.akimts.restapi.models.form;

import bstorm.akimts.restapi.models.entity.ProductType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class ProductForm {

    private String name;
    private ProductType type;

}
