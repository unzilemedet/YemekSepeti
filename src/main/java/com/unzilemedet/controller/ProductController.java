package com.unzilemedet.controller;

import com.unzilemedet.Service.ProductService;
import com.unzilemedet.dto.request.ProductSaveRequestDto;
import com.unzilemedet.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.unzilemedet.constants.EndPointList.*;

@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping(SAVE)
    public ResponseEntity<Product> save(@RequestBody @Valid ProductSaveRequestDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Product>> findALl(){
        return ResponseEntity.ok(productService.findAll());
    }
}
