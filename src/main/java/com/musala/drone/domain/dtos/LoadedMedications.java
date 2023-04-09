package com.musala.drone.domain.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoadedMedications implements Serializable {

    private static final long serialVersionUID = 1L;
    private String droneSerialNumber;
    private String medicationCode;
}
