package com.caradverts.caradverts_codevibe.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CarAdverts")
public class CarAdvert {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "fuelType", nullable = false)
    private String fuelType;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "isNew", nullable = false)
    private Boolean isNew;

    @Column(name = "mileage", nullable = true)
    private int mileage;

    @Column(name = "firstRegistration", nullable = true)
    private Date firstRegistration;
}
