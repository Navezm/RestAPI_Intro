package bstorm.akimts.restapi.models.form;

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
    private ProductTypeForm type;

}
