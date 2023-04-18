package com.unzilemedet.controller;

import com.unzilemedet.Service.OrderService;
import com.unzilemedet.dto.request.OrderSaveRequestDto;
import com.unzilemedet.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.unzilemedet.constants.EndPointList.FIND_ALL;
import static com.unzilemedet.constants.EndPointList.SAVE;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }
    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestBody @Valid OrderSaveRequestDto dto){
        return ResponseEntity.ok(orderService.save(dto));
    }





}
