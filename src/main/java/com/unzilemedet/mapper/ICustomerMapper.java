package com.unzilemedet.mapper;

import com.unzilemedet.dto.request.RegisterRequestDto;
import com.unzilemedet.dto.response.RegisterResponseDto;
import com.unzilemedet.entity.Customer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    Customer fromRequestDtoToCustomer(final RegisterRequestDto dto);

    RegisterResponseDto toRegisterResponseDto(final Customer customer);




}
