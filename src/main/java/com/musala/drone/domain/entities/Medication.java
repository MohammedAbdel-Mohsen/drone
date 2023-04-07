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

    @Column(name = "CODE")
    @Pattern(regexp = "^[A-Z0-9_]*$")
    @Id
    private String code;

    @Column(name = "NAME", unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$")
    private String name;

    @Column(name = "WEIGHT")
    private Integer weight;

    @OneToOne(mappedBy = "medication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonBackReference
    private MedicationPhoto medicationPhoto;

}
