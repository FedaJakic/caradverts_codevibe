package com.caradverts.caradverts_codevibe.dto;

import java.util.Date;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CarAdvertDTO {
    @Min(message = "Field ID must me positive integer", value = 1)
    private Long id;
    private String title;
    private String fuelType;
    @Min(message = "Field price must me positive integer", value = 0)
    private Integer price;
    private Boolean isNew;
    @Min(message = "Field mileage must me positive integer", value = 0)
    private int mileage;

    private Date firstRegistration;
}
