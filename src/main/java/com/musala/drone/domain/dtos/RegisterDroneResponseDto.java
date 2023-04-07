package com.musala.drone.domain.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterDroneResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
}
