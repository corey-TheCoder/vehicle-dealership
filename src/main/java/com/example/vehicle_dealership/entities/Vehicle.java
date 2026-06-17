package com.example.vehicle_dealership.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

//describes data - db table
@Entity
@Table(name = "vehicles")
@AllArgsConstructor //Lombok annotation, not JPA
@NoArgsConstructor//Lombok - needed for spring data jpa
@Getter//Lombok
@Setter//Lombok
public class Vehicle {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GeneratedValue is auto increment
    private Long id;

    //validation for VIN
    @NotBlank(message = "VIN number is required")
    @Column(nullable = false, unique = true, length = 17)
    @Size(min=17, max=17,message="Vin must be 17 characters")
    private String vin;

    //validation for year
    @NotNull(message = "Year is required")
    @Min(value = 1886, message = "Year must be 1886 or later")
    private Integer year;

    //validation for make
    @NotBlank(message="Make is required")
    @Column(nullable = false, length = 50)
    private String make;

    //valid for model
    @NotBlank(message="Model is required")
    @Column(nullable = false, length = 50)
    private String model;

    //valid vehicleType
    @NotBlank(message = "Vehicle type is required")
    @Column(nullable = false, length = 50)
    private String vehicleType;

    //valid color
    @NotBlank(message = "Color is required")
    @Column(nullable = false, length = 50)
    private String color;

    //valid odometer
    @NotNull(message = "Odometer is required")
    @PositiveOrZero(message = "Odometer must be positive")
    private Integer odometer;

    //valid for price
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", message = "Price cannot be negative")
    @DecimalMax(value = "500000" , message = "Price cannot exceed $500.000")
    private BigDecimal price;

}
