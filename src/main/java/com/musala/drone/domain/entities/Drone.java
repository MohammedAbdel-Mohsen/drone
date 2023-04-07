package com.musala.drone.domain.entities;

import com.musala.drone.domain.enums.DroneModel;
import com.musala.drone.domain.enums.DroneState;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Table(name = "DRONE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drone implements Serializable {

    @Id
    @Column(name = "SERIAL_NUMBER", length = 100)
    @Length(max = 100)
    private String serialNumber;

    @Column(name = "DRONE_MODEL")
    @Enumerated(EnumType.STRING)
    private DroneModel droneModel;

    @Column(name = "WEIGHT_LIMIT")
    @Max(value = 500)
    private Integer weightLimit;

    @Column(name = "BATTERY_CAPACITY", columnDefinition = "INTEGER DEFAULT 100")
    @DecimalMax(value = "100")
    private Integer batteryCapacity;

    @Column(name = "STATE")
    @Enumerated(EnumType.STRING)
    private DroneState state;


    @PrePersist
    @PreUpdate
    public void defaultBatteryCapacity() {

        if (batteryCapacity == null) {

            batteryCapacity = 100;

        }

    }

}
