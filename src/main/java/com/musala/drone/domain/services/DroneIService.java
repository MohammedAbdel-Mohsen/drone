package com.musala.drone.domain.services;

import com.musala.drone.domain.dtos.*;
import org.springframework.stereotype.Service;

@Service
public interface DroneIService {

    public RegisterDroneResponseDto registerDrone(RegisterDroneRequestDto registerDroneRequestDto);

    public LoadDroneMedicationsResponseDto loadDrone(LoadDroneMedicationsRequestDto loadDroneMedicationsRequestDto);

    public void checkDroneLoadedMedications();

    public void checkAvailableDrones();

    public void checkDroneBatteryPeriodic();

    public CheckDroneBatteryResponseDto checkDroneBattery(CheckDroneBatteryRequestDto checkDroneBatteryRequestDto);

}
