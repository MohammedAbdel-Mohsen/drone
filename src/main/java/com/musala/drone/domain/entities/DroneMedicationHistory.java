package com.musala.drone.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "DRONE_MEDICATION_HISTORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroneMedicationHistory implements Serializable {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DRONE_MEDICATION_ID_SEQ")
    @SequenceGenerator(sequenceName = "DRONE_MEDICATION_ID_SEQ", allocationSize = 1,
            name = "DRONE_MEDICATION_ID_SEQ")
    private Integer id;

    @Column(name = "DRONE_ID")
    private String droneId;

    @Column(name = "MEDICATION_ID")
    private Integer medicationId;

    @Column(name = "LOADING_TIME")
    private Timestamp loadingTime;

}
