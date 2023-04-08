package com.musala.drone.domain.repository;

import com.musala.drone.domain.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepo extends JpaRepository<Medication,String> {
}
