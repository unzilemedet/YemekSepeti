package com.unzilemedet.mapper;

import com.unzilemedet.dto.request.ProductSaveRequestDto;
import com.unzilemedet.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {
    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

   Product fromDtoToProduct(ProductSaveRequestDto dto);

}
