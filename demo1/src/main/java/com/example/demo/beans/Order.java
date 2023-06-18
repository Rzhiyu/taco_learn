package com.example.demo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order{
    //private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date placedAt;

    @Column(name = "deliveryName")
    @NotBlank(message="Name is required")
    private String name;

    @Column(name = "deliveryStreet")
    @NotBlank(message="Street is required")
    private String street;

    @Column(name = "deliveryCity")
    @NotBlank(message="City is required")
    private String city;

    @Column(name = "deliveryState")
    @NotBlank(message="State is required")
    private String state;

    @Column(name = "deliveryZip")
    @NotBlank(message="Zip code is required")
    private String zip;


    //@CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;


    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;


    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;
    @JoinTable(name = "taco_order_tacos",joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tacos_id", referencedColumnName = "id"))
    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();

//    @ManyToOne
//    private User user;
    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placeAt(){
        this.placedAt = new Date();
    }
}