package com.musala.drone.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.musala.drone.domain.dtos.CheckAvailableDronesResponseDto;
import com.musala.drone.domain.dtos.CheckDroneBatteryRequestDto;
import com.musala.drone.domain.dtos.CheckDroneBatteryResponseDto;
import com.musala.drone.domain.dtos.DroneDto;
import com.musala.drone.domain.entities.Drone;
import com.musala.drone.domain.enums.DroneModel;
import com.musala.drone.domain.exception.CustomException;
import com.musala.drone.domain.mapper.DroneMapper;
import com.musala.drone.domain.repository.DroneBatteryHistoryRepo;
import com.musala.drone.domain.repository.DroneRepo;
import com.musala.drone.domain.repository.MedicationHistoryRepo;
import com.musala.drone.domain.repository.MedicationPhotoRepo;
import com.musala.drone.domain.repository.MedicationRepo;
import com.musala.drone.domain.util.ResourceBundleConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DroneService.class, ResourceBundleConfig.class})
@ExtendWith(SpringExtension.class)
class DroneServiceTest {
    @MockBean
    private DroneBatteryHistoryRepo droneBatteryHistoryRepo;

    @MockBean
    private DroneMapper droneMapper;

    @MockBean
    private DroneRepo droneRepo;

    @Autowired
    private DroneService droneService;

    @MockBean
    private MedicationHistoryRepo medicationHistoryRepo;

    @MockBean
    private MedicationPhotoRepo medicationPhotoRepo;

    @MockBean
    private MedicationRepo medicationRepo;

    @Autowired
    private ResourceBundleConfig resourceBundleConfig;

    /**
     * Method under test: {@link DroneService#checkAvailableDrones()}
     */
    @Test
    void testCheckAvailableDrones() throws CustomException {
        when(droneRepo.findAllByStateIn(Mockito.<List<String>>any())).thenReturn(new ArrayList<>());
        assertThrows(CustomException.class, () -> droneService.checkAvailableDrones());
        verify(droneRepo).findAllByStateIn(Mockito.<List<String>>any());
    }

    /**
     * Method under test: {@link DroneService#checkAvailableDrones()}
     */
    @Test
    void testCheckAvailableDrones2() throws CustomException {
        DroneDto droneDto = new DroneDto();
        droneDto.setBatteryCapacity(10.0d);
        droneDto.setDroneModel(DroneModel.LIGHT_WEIGHT);
        droneDto.setSerialNumber("42");
        droneDto.setState("MD");
        droneDto.setWeightLimit(3);
        when(droneMapper.toDroneDto(Mockito.<Drone>any())).thenReturn(droneDto);

        ArrayList<Drone> droneList = new ArrayList<>();
        droneList.add(new Drone());
        when(droneRepo.findAllByStateIn(Mockito.<List<String>>any())).thenReturn(droneList);
        CheckAvailableDronesResponseDto actualCheckAvailableDronesResult = droneService.checkAvailableDrones();
        assertEquals("600", actualCheckAvailableDronesResult.getCode());
        assertEquals("List of available drones are returned successfully", actualCheckAvailableDronesResult.getMessage());
        assertEquals(1, actualCheckAvailableDronesResult.getDroneDtoList().size());
        verify(droneMapper).toDroneDto(Mockito.<Drone>any());
        verify(droneRepo).findAllByStateIn(Mockito.<List<String>>any());
    }

    /**
     * Method under test: {@link DroneService#checkDroneBattery(CheckDroneBatteryRequestDto)}
     */
    @Test
    void testCheckDroneBattery() throws CustomException {
        when(droneRepo.findById(Mockito.<String>any())).thenReturn(Optional.of(new Drone()));

        CheckDroneBatteryRequestDto checkDroneBatteryRequestDto = new CheckDroneBatteryRequestDto();
        checkDroneBatteryRequestDto.setDroneSerialNumber("42");
        CheckDroneBatteryResponseDto actualCheckDroneBatteryResult = droneService
                .checkDroneBattery(checkDroneBatteryRequestDto);
        assertNull(actualCheckDroneBatteryResult.getBatteryCapacity());
        assertEquals("The Drone capacity has been retrieved successfully", actualCheckDroneBatteryResult.getMessage());
        assertEquals("42", actualCheckDroneBatteryResult.getDroneSerialNumber());
        assertEquals("600", actualCheckDroneBatteryResult.getCode());
        verify(droneRepo).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link DroneService#checkDroneBattery(CheckDroneBatteryRequestDto)}
     */
    @Test
    void testCheckDroneBattery2() throws CustomException {
        when(droneRepo.findById(Mockito.<String>any())).thenReturn(Optional.empty());

        CheckDroneBatteryRequestDto checkDroneBatteryRequestDto = new CheckDroneBatteryRequestDto();
        checkDroneBatteryRequestDto.setDroneSerialNumber("42");
        assertThrows(CustomException.class, () -> droneService.checkDroneBattery(checkDroneBatteryRequestDto));
        verify(droneRepo).findById(Mockito.<String>any());
    }
}

