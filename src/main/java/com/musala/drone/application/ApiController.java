package com.musala.drone.application;

import com.musala.drone.domain.dtos.*;
import com.musala.drone.domain.exception.CustomException;
import com.musala.drone.domain.services.DroneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private DroneService droneService;

    @PostMapping(path = "/registerDrone")
    public ResponseEntity<RegisterDroneResponseDto> registerDrone
            (@Valid @RequestBody RegisterDroneRequestDto registerDroneRequestDto) throws CustomException {

        RegisterDroneResponseDto registerDroneResponseDto = droneService.registerDrone(registerDroneRequestDto);
        return ResponseEntity.ok(registerDroneResponseDto);
    }

    @PostMapping(path = "/loadDroneMedications")
    public ResponseEntity<LoadDroneMedicationsResponseDto> loadDroneMedications(@Valid @RequestBody LoadDroneMedicationsRequestDto loadDroneMedicationsRequestDto) throws CustomException {

        LoadDroneMedicationsResponseDto loadDroneMedicationsResponseDto = droneService.loadDrone(loadDroneMedicationsRequestDto);
        return ResponseEntity.ok(loadDroneMedicationsResponseDto);
    }

    @PostMapping(path = "/checkLoadedDroneMedications")
    public ResponseEntity<CheckLoadedMedicationsResponseDto> checkLoadedMedications(@Valid @RequestBody CheckLoadedMedicationsRequestDto checkLoadedMedicationsRequestDto) throws CustomException {
        droneService.checkDroneLoadedMedications(checkLoadedMedicationsRequestDto);
        return ResponseEntity.ok(new CheckLoadedMedicationsResponseDto());
    }

    @GetMapping(path = "/checkAvailableDrones")
    public ResponseEntity<CheckAvailableDronesResponseDto> checkAvailableDronesForLoading() throws CustomException {

        CheckAvailableDronesResponseDto checkAvailableDronesResponseDto = droneService.checkAvailableDrones();
        return ResponseEntity.ok(checkAvailableDronesResponseDto);

    }

    @PostMapping(path = "/checkDroneBattery")
    public ResponseEntity<CheckDroneBatteryResponseDto> checkDroneBattery(@Valid @RequestBody CheckDroneBatteryRequestDto checkDroneBatteryRequestDto) throws CustomException {

        CheckDroneBatteryResponseDto checkDroneBatteryResponseDto=droneService.checkDroneBattery(checkDroneBatteryRequestDto);
        return ResponseEntity.ok(checkDroneBatteryResponseDto);
    }


}
