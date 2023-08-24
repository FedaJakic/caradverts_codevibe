package com.caradverts.caradverts_codevibe.dto;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.caradverts.caradverts_codevibe.model.CarAdvert;

@Mapper(componentModel = "spring")
public interface CarAdvertMapper {
    CarAdvertMapper MAPPER = Mappers.getMapper(CarAdvertMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCarAdvertFromDto(CarAdvertDTO carAdvertDTO, @MappingTarget CarAdvert carAdvert);

    CarAdvertDTO mapCarAdvertToCarAdvertDTO(CarAdvert carAdvert);

    CarAdvert mapCarAdvertDTOToCarAdvert(CarAdvertDTO carAdvertDTO);
}