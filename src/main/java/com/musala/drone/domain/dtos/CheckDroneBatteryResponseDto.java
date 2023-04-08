package com.musala.drone.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CheckDroneBatteryResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "serialNumber")
    private String droneSerialNumber = null;

    @JsonProperty(value = "capacity")
    private Integer batteryCapacity = null;

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "message")
    private String message;

}
