package com.musala.drone.domain.services;

import com.musala.drone.domain.dtos.RegisterDroneRequestDto;
import com.musala.drone.domain.dtos.RegisterDroneResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface DroneIService {

    public RegisterDroneResponseDto registerDrone(RegisterDroneRequestDto registerDroneRequestDto);

    public void loadDrone();

    public void checkDroneLoadedMedications();

    public void checkAvailableDrones();

    public void checkDroneBatteryPeriodic();

}
