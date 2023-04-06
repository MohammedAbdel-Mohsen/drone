package com.musala.drone.domain.services;

import org.springframework.stereotype.Service;

@Service
public interface DroneIService {

    public void registerDrone();

    public void loadDrone();

    public void checkDroneLoadedMedications();

    public void checkAvailableDrones();

    public void checkDroneBatteryPeriodic();

}
