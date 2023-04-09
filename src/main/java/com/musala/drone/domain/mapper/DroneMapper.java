package com.musala.drone.domain.mapper;

import com.musala.drone.domain.dtos.DroneDto;
import com.musala.drone.domain.dtos.LoadDroneMedicationsRequestDto;
import com.musala.drone.domain.dtos.RegisterDroneRequestDto;
import com.musala.drone.domain.entities.Drone;
import com.musala.drone.domain.entities.Medication;
import com.musala.drone.domain.entities.MedicationPhoto;
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
            @Mapping(target = "serialNumber", source = "drone.serialNumber"),
            @Mapping(target = "droneModel", source = "drone.droneModel"),
            @Mapping(target = "weightLimit", source = "drone.weightLimit"),
            @Mapping(target = "batteryCapacity", source = "drone.batteryCapacity"),
            @Mapping(target = "state", source = "drone.state"),
    })
    public abstract DroneDto toDroneDto(Drone drone);

    @Mappings({
            @Mapping(target = "name", source = "loadDroneMedicationsRequestDto.medicationName"),
            @Mapping(target = "code", source = "loadDroneMedicationsRequestDto.code"),
            @Mapping(target = "weight", source = "loadDroneMedicationsRequestDto.weight"),
    })
    public abstract Medication toMedicationEntity(LoadDroneMedicationsRequestDto loadDroneMedicationsRequestDto);

    @Mappings({

            @Mapping(target = "photo", source = "loadDroneMedicationsRequestDto.image"),
    })
    public abstract MedicationPhoto toMedicationPhotoEntity(LoadDroneMedicationsRequestDto loadDroneMedicationsRequestDto);

}
