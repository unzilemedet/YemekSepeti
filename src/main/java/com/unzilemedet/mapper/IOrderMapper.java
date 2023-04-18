package com.unzilemedet.mapper;

import com.unzilemedet.dto.request.OrderSaveRequestDto;
import com.unzilemedet.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOrderMapper {
    IOrderMapper INSTANCE= Mappers.getMapper(IOrderMapper.class);




    Order toOrder(final OrderSaveRequestDto dto);

}
