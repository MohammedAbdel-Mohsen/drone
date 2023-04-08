package com.musala.drone.domain.repository;

import com.musala.drone.domain.entities.DroneBatteryHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneBatteryHistoryRepo extends JpaRepository<DroneBatteryHistory,Integer> {
}
