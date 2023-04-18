package com.unzilemedet.mapper;

import com.unzilemedet.dto.request.RegisterRestaurantRequestDto;
import com.unzilemedet.dto.response.RegisterRestaurantResponseDto;
import com.unzilemedet.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantMapper {
    IRestaurantMapper INSTANCE= Mappers.getMapper(IRestaurantMapper.class);
    Restaurant toRestaurant(final RegisterRestaurantRequestDto dto);
    RegisterRestaurantResponseDto toRegisterRestaurantResponseDto (final  Restaurant restaurant);

}
