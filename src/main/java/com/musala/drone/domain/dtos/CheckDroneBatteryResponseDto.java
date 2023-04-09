package com.musala.drone.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musala.drone.model.ApiResponseDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CheckDroneBatteryResponseDto extends ApiResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "serialNumber")
    private String droneSerialNumber = null;

    @JsonProperty(value = "capacity")
    private Integer batteryCapacity = null;



}
