package bstorm.akimts.restapi.models.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Security_Address")
public class Address extends BaseEntity<Long> {

    @Column(nullable = false)
    @Getter @Setter
    private String street;

    @Column(nullable = false)
    @Getter @Setter
    private String streetNumber;

    @Column(nullable = false)
    @Getter @Setter
    private String city;

    @Column(columnDefinition = "varchar(250) default 'BE'")
    @Getter @Setter
    private String country;

    public Address(String street, String streetNumber, String city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
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
