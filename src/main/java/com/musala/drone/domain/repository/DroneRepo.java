package com.musala.drone.domain.repository;

import com.musala.drone.domain.entities.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepo extends JpaRepository<Drone, String> {

    @Query("select d FROM Drone d where d.state in('LOADING','IDLE')")
    public List<String> getAllAvailableDronesForLoading();

    List<Drone> findAllByStateIn(List<String> state);

//    @Query("select m FROM Medication m join fetch m.drone where m.serialNumber=?1 ")
//    public List<String> getLoadedMedications();
}
