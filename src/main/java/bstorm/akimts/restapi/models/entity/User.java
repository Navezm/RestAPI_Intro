package bstorm.akimts.restapi.models.entity;

import bstorm.akimts.restapi.models.PayType;
import bstorm.akimts.restapi.models.entity.Address;
import bstorm.akimts.restapi.models.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Security_User")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class User extends BaseEntity<Long> {
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String username;
    @Column(nullable = false)
    @Getter @Setter
    private String password;
    @Column(nullable = false)
    @Getter @Setter
    private String email;

    @Embedded
    @Getter @Setter
    private Address address;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private PayType defaultPayType;

    @ManyToMany(targetEntity = Groupe.class)
    @JoinTable(name = "Security_UserGroup")
    private Set<Groupe> groupes = new HashSet<>();

    public User(String username, String password, String email, Address address, PayType defaultPayType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.defaultPayType = defaultPayType;
    }

    @PrePersist()
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @PreUpdate()
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }

}
