package com.unzilemedet.controller;

import com.unzilemedet.Service.RestaurantService;
import com.unzilemedet.dto.request.RegisterRestaurantRequestDto;
import com.unzilemedet.dto.request.RestaurantSaveRequestDto;
import com.unzilemedet.dto.response.RegisterRestaurantResponseDto;
import com.unzilemedet.entity.Restaurant;
import com.unzilemedet.entity.jointable.RestaurantOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.unzilemedet.constants.EndPointList.*;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Restaurant>> findAll() {
        return ResponseEntity.ok(restaurantService.findAll());
    }
    @GetMapping(FIND_ALL_RESTAURANT_ORDER)
    public ResponseEntity<List<RestaurantOrder>> findAllRestaurantOrder(Long restaurantId) {
        return ResponseEntity.ok(restaurantService.findAllRestaurantOrder(restaurantId));
    }
    @PutMapping(REGISTER)
    public ResponseEntity<RegisterRestaurantResponseDto> register(@RequestBody RegisterRestaurantRequestDto dto) {
        return ResponseEntity.ok(restaurantService.register(dto));
    }

}
