package com.caradverts.caradverts_codevibe.dto;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarAdvertDTO {
    @Min(message = "Field ID must me positive integer", value = 1)
    @NotNull(message = "Field ID can't be NULL!")
    private Long id;

    @NotNull(message = "Field title can't be empty!")
    @NotBlank(message = "Field title can't be blank!")
    private String title;

    @NotNull(message = "Field fuelType can't be NULL!")
    private String fuelType;

    @Min(message = "Field price must me positive integer", value = 0)
    private Integer price;

    @NotNull(message = "Field isNew can't be NULL!")
    private Boolean isNew;

    @Min(message = "Field mileage must me positive integer", value = 0)
    private int mileage;

    private Date firstRegistration;
}
