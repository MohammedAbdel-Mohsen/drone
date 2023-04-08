package com.musala.drone.domain.repository;

import com.musala.drone.domain.entities.DroneMedicationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationHistoryRepo extends JpaRepository<DroneMedicationHistory,Integer> {
}
