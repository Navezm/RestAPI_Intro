package bstorm.akimts.restapi.models.entity;

import bstorm.akimts.restapi.models.PayType;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@EqualsAndHashCode
@ToString
public class Command extends BaseEntity<Long> {
    private LocalDate shippingDate;
    private PayType payType;
    @Embedded
    private Address shippingAddress;

    @OneToMany(targetEntity = CommandLine.class)
    private Set<CommandLine> commandLines = new HashSet<>();

    @ManyToOne(targetEntity = User.class)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Set<CommandLine> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(Set<CommandLine> commandLines) {
        this.commandLines = commandLines;
    }

//    @Override
//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDate.now();
//    }
//
//    @Override
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDate.now();
//    }
}
