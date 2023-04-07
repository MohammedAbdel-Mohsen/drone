package com.musala.drone.domain.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoadDroneMedicationsRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 100, message = "{validation.name.size.too_long}")
    private String droneSerialNumber;
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$")
    private String medicationName;
    private Integer weight;
    @Pattern(regexp = "^[A-Z0-9_]*$")
    private String code;
    private Byte[] image;

}
