package com.musala.drone.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DroneModel {

    LIGHT_WEIGHT("LIGHT_WEIGHT"),
    MIDDLE_WEIGHT("MIDDLE_WEIGHT"),
    CRUISER_WEIGHT("CRUISER_WEIGHT"),
    HEAVY_WEIGHT("HEAVY_WEIGHT");

    private String value;

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static DroneModel fromValue(String text) {
        for (DroneModel b : DroneModel.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }

}
