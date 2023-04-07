package com.musala.drone.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CheckDroneBatteryResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "serialNumber")
    private String droneSerialNumber;
    @JsonProperty(value = "capacity")
    private String batteryCapacity;

}
