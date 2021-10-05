package bstorm.akimts.restapi.models.entity;

import bstorm.akimts.restapi.models.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Security_Role")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity<Long> {
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String nom;

    @PrePersist()
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @PreUpdate()
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}
