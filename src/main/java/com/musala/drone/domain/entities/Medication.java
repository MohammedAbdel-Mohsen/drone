package com.musala.drone.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "MEDICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDICATION_ID_SEQ")
    @SequenceGenerator(sequenceName = "MEDICATION_ID_SEQ", allocationSize = 1,
            name = "MEDICATION_ID_SEQ")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$")
    private String name;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "CODE")
    @Pattern(regexp = "^[A-Z0-9_]*$")
    private String code;

    @OneToOne(mappedBy = "medication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonBackReference
    private MedicationPhoto medicationPhoto;

}
