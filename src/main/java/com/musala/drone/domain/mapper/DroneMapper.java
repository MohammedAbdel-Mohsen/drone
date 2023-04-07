package com.musala.drone.domain.mapper;

import com.musala.drone.domain.dtos.LoadDroneMedicationsRequestDto;
import com.musala.drone.domain.dtos.RegisterDroneRequestDto;
import com.musala.drone.domain.entities.Drone;
import com.musala.drone.domain.entities.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper( componentModel = "spring")
public abstract class DroneMapper {

    @Mappings({
            @Mapping(target = "serialNumber", source = "registerDroneRequestDto.serialNumber"),
            @Mapping(target = "droneModel", source = "registerDroneRequestDto.model"),
            @Mapping(target = "weightLimit", source = "registerDroneRequestDto.weightLimit"),
            @Mapping(target = "batteryCapacity", source = "registerDroneRequestDto.batteryCapacity"),
            @Mapping(target = "state", source = "registerDroneRequestDto.state"),
    })
    public abstract Drone toDroneEntity(RegisterDroneRequestDto registerDroneRequestDto);

    @Mappings({
            @Mapping(target = "name", source = "loadDroneMedicationsRequestDto.medicationName"),
            @Mapping(target = "code", source = "loadDroneMedicationsRequestDto.code"),
            @Mapping(target = "weight", source = "loadDroneMedicationsRequestDto.weight"),
            @Mapping(target = "batteryCapacity", source = "loadDroneMedicationsRequestDto.batteryCapacity"),
            @Mapping(target = "state", source = "loadDroneMedicationsRequestDto.state"),
    })
    public abstract Medication toMedicationEntity(LoadDroneMedicationsRequestDto loadDroneMedicationsRequestDto);


}
