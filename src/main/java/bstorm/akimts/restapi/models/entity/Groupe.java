package bstorm.akimts.restapi.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Security_Groupe")
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "Security_Groupe_Role")
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Groupe)) return false;
        Groupe groupe = (Groupe) o;
        return Objects.equals(id, groupe.id) && Objects.equals(nom, groupe.nom) && Objects.equals(roles, groupe.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, roles);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Groupe{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}