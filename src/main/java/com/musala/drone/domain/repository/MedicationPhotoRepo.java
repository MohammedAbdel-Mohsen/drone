package com.musala.drone.domain.repository;

import com.musala.drone.domain.entities.MedicationPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationPhotoRepo extends JpaRepository<MedicationPhoto,Integer> {
}
