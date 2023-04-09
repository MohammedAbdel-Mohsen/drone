package com.musala.drone.domain.services;

import com.musala.drone.domain.dtos.*;
import com.musala.drone.domain.exception.CustomException;
import org.springframework.stereotype.Service;

@Service
public interface DroneIService {

    public RegisterDroneResponseDto registerDrone(RegisterDroneRequestDto registerDroneRequestDto) throws CustomException;

    public LoadDroneMedicationsResponseDto loadDrone(LoadDroneMedicationsRequestDto loadDroneMedicationsRequestDto) throws CustomException;

    public CheckLoadedMedicationsResponseDto checkDroneLoadedMedications(CheckLoadedMedicationsRequestDto checkLoadedMedicationsRequestDto)throws CustomException;

    public CheckAvailableDronesResponseDto checkAvailableDrones() throws CustomException;

    public void checkDroneBatteryPeriodic();

    public CheckDroneBatteryResponseDto checkDroneBattery(CheckDroneBatteryRequestDto checkDroneBatteryRequestDto)
            throws CustomException;

}
