package com.unzilemedet.controller;

import com.unzilemedet.Service.CustomerService;
import com.unzilemedet.dto.request.ActivateRequestDto;
import com.unzilemedet.dto.request.LoginRequestDto;
import com.unzilemedet.dto.request.RegisterRequestDto;
import com.unzilemedet.dto.response.RegisterResponseDto;
import com.unzilemedet.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

import static com.unzilemedet.constants.EndPointList.*;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private  final CustomerService customerService;

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto) {
        return ResponseEntity.ok(customerService.register(dto));
    }

    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody ActivateRequestDto dto){
        return ResponseEntity.ok(customerService.activateStatus(dto));
    }

 @PostMapping(LOGIN)
    public  ResponseEntity<Boolean> login(LoginRequestDto dto){
        return  ResponseEntity.ok(customerService.login(dto));
 }

 @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
 }
}
