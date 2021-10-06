package bstorm.akimts.restapi.models.entity;

import bstorm.akimts.restapi.models.PayType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Command extends BaseEntity<Long> {
    private LocalDate shippingDate;
    private PayType payType;

    @ManyToOne(targetEntity = Address.class)
    private Address shippingAddress;

    @OneToMany(targetEntity = CommandLine.class)
    private Set<CommandLine> commandLines = new HashSet<>();

    @ManyToOne(targetEntity = User.class)
    private User user;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}
