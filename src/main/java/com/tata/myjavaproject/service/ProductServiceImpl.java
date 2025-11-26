package com.tata.myjavaproject.service;

import com.tata.myjavaproject.entity.Product;
import com.tata.myjavaproject.entity.ProductDto;
import com.tata.myjavaproject.entity.ProductType;
import com.tata.myjavaproject.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product updateProduct(Product product) {
       Product existProduct=getById(product.getId());
       existProduct.setName(product.getName());
       existProduct.setPrice(product.getPrice());
       existProduct.setProduct_city(product.getProduct_city());
       existProduct.setProductType(product.getProductType());

        return productRepository.save(existProduct);
    }

    @Override
    public Product getById(Long id) {
       Optional<Product> optionalProduct= productRepository.findById(id);
       if(!optionalProduct.isPresent()){
           throw  new RuntimeException("not found");
       }
        return optionalProduct.get();
    }

    @Override
    public Page<Product> getProductByPage(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<Product> productPage = productRepository.findAll(pageRequest);
        return productPage;
    }

    @Override
    public List<Product> getAllByPage() {
        return  productRepository.findAll();
    }

    @Override
    public List<Product> getAllByDate(LocalDate startDate, LocalDate endDate) {
        return productRepository.findByRequestDateBetween(startDate,endDate);
    }

    @Override
    public List<Product> getAllByProductType(ProductType productType) {
        return productRepository.findByProductType(productType);
    }


}

