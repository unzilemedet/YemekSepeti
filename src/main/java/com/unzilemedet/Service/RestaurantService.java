package com.unzilemedet.Service;

import com.unzilemedet.Service.joinservice.RestaurantOrderService;
import com.unzilemedet.dto.request.RegisterRestaurantRequestDto;
import com.unzilemedet.dto.response.RegisterRestaurantResponseDto;
import com.unzilemedet.entity.Restaurant;
import com.unzilemedet.entity.jointable.RestaurantOrder;
import com.unzilemedet.exception.ErrorType;
import com.unzilemedet.exception.YemekSepetiException;
import com.unzilemedet.mapper.IRestaurantMapper;
import com.unzilemedet.repository.IRestaurantRepository;
import com.unzilemedet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService extends ServiceManager<Restaurant,Long> {
    private final IRestaurantRepository restaurantRepository;
    private final ProductService productService;
    private final RestaurantOrderService restaurantOrderService;

    public RestaurantService(IRestaurantRepository restaurantRepository,
                             RestaurantOrderService restaurantOrderService,
                             ProductService productService) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;
        this.restaurantOrderService = restaurantOrderService;
        this.productService = productService;
    }
    public RegisterRestaurantResponseDto register(RegisterRestaurantRequestDto dto) {
        if (restaurantRepository.existsByAddress(dto.getAddress())) {
            throw new YemekSepetiException(ErrorType.ERROR);
        }
        Restaurant restaurant = IRestaurantMapper.INSTANCE.toRestaurant(dto);
        RegisterRestaurantResponseDto registerRestaurantResponseDto = IRestaurantMapper.INSTANCE.toRegisterRestaurantResponseDto(restaurant);
        save(restaurant);
        return registerRestaurantResponseDto;
    }

    public List<RestaurantOrder> findAllRestaurantOrder(Long restaurantId) {
        return restaurantOrderService.findAllRestaurantsOrder(restaurantId);
    }


}
