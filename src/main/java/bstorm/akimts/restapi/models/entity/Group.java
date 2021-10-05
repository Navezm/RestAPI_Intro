package bstorm.akimts.restapi.models.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Security_Groupe")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Group extends BaseEntity<Long> {
    @Getter @Setter
    private String name;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "Security_Groupe_Role")
    @Getter @Setter
    private Set<Role> roles = new HashSet<>();

    @PrePersist()
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @PreUpdate()
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}