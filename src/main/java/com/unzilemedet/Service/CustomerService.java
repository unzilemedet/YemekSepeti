package com.unzilemedet.Service;

import com.unzilemedet.dto.request.ActivateRequestDto;
import com.unzilemedet.dto.request.LoginRequestDto;
import com.unzilemedet.dto.request.RegisterRequestDto;
import com.unzilemedet.dto.response.RegisterResponseDto;
import com.unzilemedet.entity.Customer;

import com.unzilemedet.mapper.ICustomerMapper;
import com.unzilemedet.repository.ICustomerRepository;
import com.unzilemedet.utility.CodeGenerator;
import com.unzilemedet.utility.ServiceManager;

import com.unzilemedet.utility.enums.EStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service

public class CustomerService extends ServiceManager<Customer,Long> {
    private final ICustomerRepository customerRepository;


    public CustomerService(ICustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository=customerRepository;

    }

    public RegisterResponseDto register(RegisterRequestDto dto) {
        Customer customer = ICustomerMapper.INSTANCE.fromRequestDtoToCustomer(dto);
        if(dto.getPassword().equals(dto.getRepassword())){
        customer.setActivationCode(CodeGenerator.generateCode());
        save(customer);
    }else{
        throw new RuntimeException("Şifreler aynı olmalıdır");
    }
      RegisterResponseDto responseDto =  ICustomerMapper.INSTANCE.toRegisterResponseDto(customer);
  return responseDto;

    }


    public Boolean activateStatus(ActivateRequestDto dto){
       Optional<Customer> customer = findById(dto.getId());
       if(customer.isEmpty()){
           throw new RuntimeException("Böyle bir kullanıcı yok.");
       }else if (customer.get().getActivationCode().equals(dto.getActivationCode())){
           customer.get().setStatus(EStatus.ACTIVE);
           update(customer.get());
           return true;
       }
       throw new RuntimeException("Aktivasyon kod hatası");
    }
    public  Boolean login(LoginRequestDto dto){
        Optional<Customer> customer =customerRepository.findByEmailAndPassword(dto.getEmail(),dto.getPassword());
    if(customer.isEmpty()){
        throw  new RuntimeException("Kullanıcı bulunamadı");
    } else if (!customer.get().getStatus().equals(EStatus.ACTIVE)) {
        throw  new RuntimeException("Giriş yapmadan önce aktivasyon kodunu doğrulayınız.");

    }return  true;

    }

    }


















