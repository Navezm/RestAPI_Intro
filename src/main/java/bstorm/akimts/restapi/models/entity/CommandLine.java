package bstorm.akimts.restapi.models.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CommandLine extends BaseEntity<Long> {

    @Getter @Setter
    private Long commandId;
    @Getter @Setter
    private Long productId;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "productId", updatable = false, insertable = false)
    @Getter @Setter
    private Product product;

    @Getter @Setter
    private float qtt;


    @PrePersist()
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @PreUpdate()
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}
