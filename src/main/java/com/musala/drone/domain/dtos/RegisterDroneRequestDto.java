package com.musala.drone.domain.dtos;

import jakarta.validation.constraints.Max;
import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterDroneRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String serialNumber;
    private String model;
    @Max(500)
    private Integer weightLimit;
    @Max(100)
    private Integer batteryCapacity;
    private String state;
}
