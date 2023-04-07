package com.musala.drone.domain.dtos;

import lombok.Data;

import java.io.Serializable;
@Data
public class RegisterDroneRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String serialNumber;
    private String model;
    private Integer weightLimit;
    private Integer batteryCapacity;
    private String state;
}
