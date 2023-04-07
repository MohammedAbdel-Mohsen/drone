package com.musala.drone.domain.dtos;

import com.musala.drone.domain.enums.DroneModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class DroneDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String serialNumber;

    private DroneModel droneModel;

    private Integer weightLimit;

    private Double batteryCapacity;

    private String state;

}
