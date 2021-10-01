package bstorm.akimts.restapi.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CommandLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long commandId;
    private Long productId;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "productId", updatable = false, insertable = false)
    private Product product;

    private float qtt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommandId() {
        return commandId;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getQtt() {
        return qtt;
    }

    public void setQtt(float qtt) {
        this.qtt = qtt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandLine)) return false;

        CommandLine that = (CommandLine) o;

        return !Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        return result;
    }
}
