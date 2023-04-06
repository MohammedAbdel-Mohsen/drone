package com.musala.drone.domain.services;

import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DroneService implements DroneIService{

    @Override
    public void registerDrone() {

    }

    @Override
    public void loadDrone() {

    }

    @Override
    public void checkDroneLoadedMedications() {

    }

    @Override
    public void checkAvailableDrones() {

    }

    /**
     * cron checks the drone battery life
     */
    @Override
    @Scheduled(cron = "0 */5 * ? * *")
    public void checkDroneBatteryPeriodic() {

    }
}
