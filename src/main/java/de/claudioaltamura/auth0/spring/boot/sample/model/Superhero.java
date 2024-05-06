package de.claudioaltamura.auth0.spring.boot.sample.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Superhero {

    private long id;

    @NotEmpty
    private String name;

    private String realName;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100.0")
    private double power;

}
