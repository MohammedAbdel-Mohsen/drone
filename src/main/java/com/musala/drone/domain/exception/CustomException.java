package com.musala.drone.domain.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.musala.drone.model.ApiResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomException extends Exception {

    @JsonProperty("status")
    ApiResponseDto apiResponseDto;

}
