package com.unzilemedet.Service.joinservice;

import com.unzilemedet.entity.jointable.RestaurantOrder;
import com.unzilemedet.exception.ErrorType;
import com.unzilemedet.exception.YemekSepetiException;
import com.unzilemedet.repository.joinrepository.IRestaurantOrderRepository;
import com.unzilemedet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantOrderService extends ServiceManager<RestaurantOrder,Long> {
    private final IRestaurantOrderRepository restaurantOrderRepository;

    public RestaurantOrderService(IRestaurantOrderRepository restaurantOrderRepository) {
        super(restaurantOrderRepository);
        this.restaurantOrderRepository = restaurantOrderRepository;
    }

    public List<RestaurantOrder> findAllRestaurantsOrder(Long restaurantId) {
        List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findAllRestaurantOrder(restaurantId);
        if (restaurantOrderList.size()<=0){
            throw  new YemekSepetiException(ErrorType.ERROR);
        }
        return restaurantOrderList;
    }
}
