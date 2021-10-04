package bstorm.akimts.restapi.models.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "User_possede_Role")
@EqualsAndHashCode
@ToString
public class UserRole {
    @EmbeddedId
    private UserRoleId id;

    @Column(nullable = false)
    private LocalDate startedAt;
    private LocalDate endedAt;

    @ManyToOne(targetEntity = User.class)
    @MapsId(value = "userId")
    private User user;

    @ManyToOne(targetEntity = Role.class)
    @MapsId(value = "roleId")
    private Role role;

//    @PrePersist
//    public void prePersist() {
//        this.startedAt = LocalDate.now();
//    }

    public UserRoleId getId() {
        return id;
    }

    public void setId(UserRoleId id) {
        this.id = id;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDate getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDate endedAt) {
        this.endedAt = endedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Embeddable
    public static class UserRoleId implements Serializable {
        private Long userId;
        private Long roleId;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof UserRoleId)) return false;

            UserRoleId that = (UserRoleId) o;

            if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
            return roleId != null ? roleId.equals(that.roleId) : that.roleId == null;
        }

        @Override
        public int hashCode() {
            int result = userId != null ? userId.hashCode() : 0;
            result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
            return result;
        }
    }
}
