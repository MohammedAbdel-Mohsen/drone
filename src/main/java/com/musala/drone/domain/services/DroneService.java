package com.musala.drone.domain.services;

import com.musala.drone.domain.dtos.LoadDroneMedicationsRequestDto;
import com.musala.drone.domain.dtos.LoadDroneMedicationsResponseDto;
import com.musala.drone.domain.dtos.CheckDroneBatteryRequestDto;
import com.musala.drone.domain.dtos.CheckDroneBatteryResponseDto;
import com.musala.drone.domain.dtos.RegisterDroneRequestDto;
import com.musala.drone.domain.dtos.RegisterDroneResponseDto;
import com.musala.drone.domain.entities.Drone;
import com.musala.drone.domain.entities.Medication;
import com.musala.drone.domain.entities.MedicationPhoto;
import com.musala.drone.domain.enums.DroneState;
import com.musala.drone.domain.exception.CustomException;
import com.musala.drone.domain.mapper.DroneMapper;
import com.musala.drone.domain.repository.DroneRepo;
import com.musala.drone.domain.repository.MedicationHistoryRepo;
import com.musala.drone.domain.repository.MedicationPhotoRepo;
import com.musala.drone.domain.repository.MedicationRepo;
import com.musala.drone.domain.util.ResourceBundleConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Primary
@Slf4j
@Transactional
public class DroneService implements DroneIService {

    @Autowired
    private DroneRepo droneRepo;
    @Autowired
    private MedicationRepo medicationRepo;
    @Autowired
    private MedicationPhotoRepo medicationPhotoRepo;
    @Autowired
    private MedicationHistoryRepo medicationHistoryRepo;

    @Autowired
    DroneMapper droneMapper;

    @Autowired
    ResourceBundleConfig resourceBundleConfig;

    @Override
    public RegisterDroneResponseDto registerDrone(RegisterDroneRequestDto registerDroneRequestDto) throws CustomException {
        Drone drone = null;
        RegisterDroneResponseDto registerDroneResponseDto = new RegisterDroneResponseDto();
        try {
            drone = droneMapper.toDroneEntity(registerDroneRequestDto);
        } catch (Exception exception) {
            exception.printStackTrace();
            log.info("Failed to Map RegisterDroneRequestDto to Drone Entity");

            ApiResponseDto apiResponseDto;

            apiResponseDto.setCode(resourceBundleConfig.getDroneRegistrationFailedCode()).
                    setMessage(resourceBundleConfig.getDroneRegistrationFailedMessage());

            throw new CustomException(apiResponseDto);

        }
        droneRepo.save(drone);
        log.info("Drone is inserted>>>");

        registerDroneResponseDto.setCode(resourceBundleConfig.getOperationDroneSuccessfullyCode());
        registerDroneResponseDto.setMessage(resourceBundleConfig.getDroneRegistrationFailedMessage());

        return registerDroneResponseDto;
    }

    @Override
    public LoadDroneMedicationsResponseDto loadDrone(LoadDroneMedicationsRequestDto loadDroneMedicationsRequestDto) {

        Medication medication = null;
        MedicationPhoto medicationPhoto = null;

        medication = droneMapper.toMedicationEntity(loadDroneMedicationsRequestDto);

        //droneRepo.save(medication);
        log.info("Medication has been inserted successfully");

        medicationPhoto = droneMapper.toMedicationPhotoEntity(loadDroneMedicationsRequestDto);

        //droneRepo.save(medicationPhoto);
        return new LoadDroneMedicationsResponseDto();
    }

    @Override
    public void checkDroneLoadedMedications() {

    }

    @Override
    public void checkAvailableDrones() {

        List<Drone> droneRepos = droneRepo
                .findAllByStateEquals(DroneState.IDLE.toString());

    }

    /**
     * cron checks the drone battery life
     */
    @Override
    @Scheduled(cron = "0 */5 * ? * *")
    public void checkDroneBatteryPeriodic() {
        log.info("Cron Job Is Running>>>>>>>>>>>>");

    }

    public CheckDroneBatteryResponseDto checkDroneBattery(CheckDroneBatteryRequestDto checkDroneBatteryRequestDto) throws CustomException {

        Optional<Drone> drone = droneRepo.findById(checkDroneBatteryRequestDto.getDroneSerialNumber());

        CheckDroneBatteryResponseDto checkDroneBatteryResponseDto
                = new CheckDroneBatteryResponseDto();

        checkDroneBatteryResponseDto
                .setDroneSerialNumber(checkDroneBatteryRequestDto.getDroneSerialNumber());

        if (drone.isPresent()) {

            checkDroneBatteryResponseDto.setBatteryCapacity(drone.get().getBatteryCapacity())
                    .setCode(resourceBundleConfig.getOperationDroneSuccessfullyCode())
                    .setMessage(resourceBundleConfig.getDroneCapacityRetrievedSuccessfullyMessage());

        } else {

            ApiResponseDto apiResponseDto;

            apiResponseDto.setCode(resourceBundleConfig.getDroneDoesNotPresentCode()).
                    setMessage(resourceBundleConfig.getDroneDoesNotPresentMessage());

            throw new CustomException(apiResponseDto);

        }

        return checkDroneBatteryResponseDto;

    }

}
