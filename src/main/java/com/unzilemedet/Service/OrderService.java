package com.unzilemedet.Service;

import com.unzilemedet.dto.request.OrderSaveRequestDto;
import com.unzilemedet.entity.Customer;
import com.unzilemedet.entity.Order;
import com.unzilemedet.mapper.IOrderMapper;
import com.unzilemedet.repository.IOrderRepository;
import com.unzilemedet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends ServiceManager <Order,Long>{
    private final IOrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private final RestaurantService restaurantService;

    public OrderService(IOrderRepository orderRepository,
                        CustomerService customerService,
                        ProductService productService,
                        RestaurantService restaurantService) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.restaurantService = restaurantService;
    }
    public String save(OrderSaveRequestDto dto){
        orderRepository.save(IOrderMapper.INSTANCE.toOrder(dto));
        return "Order Save Success";
    }
}
