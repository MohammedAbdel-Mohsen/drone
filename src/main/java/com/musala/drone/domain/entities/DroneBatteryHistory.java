package com.musala.drone.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "DRONE_BATTERY_HISTORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroneBatteryHistory {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DRONE_BATTERY_ID_SEQ")
    @SequenceGenerator(sequenceName = "DRONE_BATTERY_ID_SEQ", allocationSize = 1,
            name = "DRONE_BATTERY_ID_SEQ")
    private Integer id;

    @Column(name = "DRONE_ID")
    private String droneId;

    @Column(name = "BATTERY_CAPACITY")
    @Max(value = 100)
    private Integer batteryCapacity;

    @Column(name = "CHECKING_TIME")
    private Timestamp checkingTime;

}
