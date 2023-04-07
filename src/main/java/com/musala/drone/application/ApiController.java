package com.musala.drone.application;

import com.musala.drone.domain.dtos.*;
import com.musala.drone.domain.services.DroneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private DroneService droneService;
    @PostMapping(path = "/registerDrone")
    public ResponseEntity<RegisterDroneResponseDto> registerDrone(@RequestBody @Valid RegisterDroneRequestDto registerDroneRequestDto){

        droneService.registerDrone(registerDroneRequestDto);
        return ResponseEntity.ok(new RegisterDroneResponseDto());
    }

    @PostMapping(path = "/loadDroneMedications")
    public ResponseEntity<LoadDroneMedicationsResponseDto> loadDroneMedications(@RequestBody @Valid LoadDroneMedicationsRequestDto loadDroneMedicationsRequestDto){

        return ResponseEntity.ok(new LoadDroneMedicationsResponseDto());
    }

//    @PostMapping(path = "/loadDroneMedications")
//    public ResponseEntity<CheckLoadedMedicationsResponseDto> checkLoadedMedications(@RequestBody CheckLoadedMedicationsRequestDto checkLoadedMedicationsRequestDto){
//
//        return ResponseEntity.ok(new CheckLoadedMedicationsResponseDto());
//    }

    @GetMapping(path = "/checkAvailableDrones")
    public ResponseEntity<List<DroneDto>> checkAvailableDronesForLoading(){

        return ResponseEntity.ok(new ArrayList<>());

    }

    @PostMapping(path = "/checkDroneBattery")
    public ResponseEntity<CheckDroneBatteryResponseDto> checkDroneBattery(@RequestBody CheckDroneBatteryRequestDto checkDroneBatteryRequestDto){

        return ResponseEntity.ok(new CheckDroneBatteryResponseDto());
    }



}
