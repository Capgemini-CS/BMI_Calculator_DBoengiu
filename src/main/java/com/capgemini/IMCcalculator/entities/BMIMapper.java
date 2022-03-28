package com.capgemini.IMCcalculator.entities;

public class BMIMapper {
    public static BMIEntity fromDTO(BMIDto dto) {
        BMIEntity entity = new BMIEntity();

        entity.setHeight(dto.getHeight());
        entity.setMass(dto.getMass());
        entity.setMessage(dto.getMessage());

        return entity;
    }

    public static BMIDto fromEntity(BMIEntity entity) {
        BMIDto dto = new BMIDto();

        dto.setHeight(entity.getHeight());
        dto.setMass(entity.getMass());
        dto.setMessage(entity.getMessage());

        return dto;

    }
}
