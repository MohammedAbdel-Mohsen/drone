package com.musala.drone.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musala.drone.model.ApiResponseDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CheckAvailableDronesResponseDto extends ApiResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("data")
    private List<DroneDto> droneDtoList;

}
