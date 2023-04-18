package com.unzilemedet.Service;

import com.unzilemedet.dto.request.ProductSaveRequestDto;
import com.unzilemedet.entity.Product;
import com.unzilemedet.mapper.IProductMapper;
import com.unzilemedet.repository.IProductRepository;
import com.unzilemedet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends ServiceManager<Product,Long> {
    private IProductRepository productRepository;
    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository=productRepository;
    }
    public Product save(ProductSaveRequestDto dto){
        Product product = IProductMapper.INSTANCE.fromDtoToProduct(dto);
        return productRepository.save(product);
    }
     public List<Product> findAll(){
        return productRepository.findAll();
    }
}
