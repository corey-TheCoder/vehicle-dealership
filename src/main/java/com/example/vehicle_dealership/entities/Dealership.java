package com.example.vehicle_dealership.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "dealerships")
@AllArgsConstructor //Lombok annotation, not JPA
@NoArgsConstructor//Lombok - needed for spring data jpa
@Getter//Lombok
@Setter//Lombok
public class Dealership {
   @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI
    private Long id;

   //valid for name
    @NotBlank(message = "Name is required")
    @Column(nullable = false, length = 50)
    private String name;

    //valid for address
    @NotBlank(message = "Address is required")
    @Column(nullable = false, length = 100)
    private String address;

    //valid for phoneNum
    @NotBlank(message = "Phone number is required")
    @Column(nullable = false, length= 13)
    private String phoneNum;
}
