package com.musala.drone.domain.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CheckDroneBatteryRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String droneSerialNumber;

}
