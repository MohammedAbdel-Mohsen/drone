package com.musala.drone.domain.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class MedicationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Double weight;
    private String code;
    private Byte[] image;


}
