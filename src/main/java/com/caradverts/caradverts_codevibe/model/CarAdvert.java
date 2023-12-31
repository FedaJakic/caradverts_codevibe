package com.caradverts.caradverts_codevibe.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
// import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "CarAdverts")
public class CarAdvert {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @Min(message = "Field ID must me positive integer", value = 1)
    @NotNull(message = "Field ID can't be NULL!")
    private Long id;

    @Column(name = "title", nullable = false)
    @NotNull(message = "Field title can't be empty!")
    @NotBlank(message = "Field title can't be blank!")
    private String title;

    @Column(name = "fuelType", nullable = false)
    @NotNull(message = "Field fuelType can't be NULL!")
    private String fuelType;

    @Column(name = "price", nullable = false)
    @Min(message = "Field price must me positive integer", value = 0)
    private Integer price;

    @Column(name = "isNew", nullable = false)
    @NotNull(message = "Field isNew can't be NULL!")
    private Boolean isNew;

    @Column(name = "mileage", nullable = true)
    @Min(message = "Field mileage must me positive integer", value = 0)
    private int mileage;

    @Column(name = "firstRegistration", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date firstRegistration;
}
