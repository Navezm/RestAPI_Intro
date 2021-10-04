package bstorm.akimts.restapi.models.entity;

import bstorm.akimts.restapi.models.entity.BaseEntity;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Security_Role")
@ToString
public class Role extends BaseEntity<Long> {
    @Column(nullable = false, unique = true)
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        if (!super.equals(o)) return false;

        Role role = (Role) o;
        if (id != null && role.id != null && !id.equals(role.id)) return false;

        return nom != null ? nom.equals(role.nom) : role.nom == null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", isActive=").append(isActive);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }

//    @Override
//    @PrePersist()
//    public void prePersist() {
//        this.createdAt = LocalDate.now();
//    }
//
//    @Override
//    @PreUpdate()
//    public void preUpdate() {
//        this.updatedAt = LocalDate.now();
//    }
}
