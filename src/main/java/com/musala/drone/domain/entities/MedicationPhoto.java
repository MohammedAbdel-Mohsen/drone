package com.musala.drone.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "MEDICATION_PHOTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationPhoto implements Serializable {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDICATION_PHOTO_ID_SEQ")
    @SequenceGenerator(sequenceName = "MEDICATION_PHOTO_ID_SEQ", allocationSize = 1,
            name = "MEDICATION_PHOTO_ID_SEQ")
    private Integer id;

    @Column(name = "PHOTO", columnDefinition = "BLOB")
    @Lob
    private Byte[] photo;

    @OneToOne
    @JoinColumn(name = "MEDICATION_PHOTO_ID", referencedColumnName = "ID")
    Medication medication;

}
