package com.tata.myjavaproject.service;

import com.tata.myjavaproject.entity.Product;
import com.tata.myjavaproject.entity.ProductDto;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);
    void    deleteProduct(Long id);
    Product updateProduct(Product product);
    Product getById(Long id);
    Page<Product> getProductByPage(int pageNo, int pageSize);
    public List<Product> getAllByPage();
    List<Product> getAllByDate(LocalDate startDate, LocalDate endDate);


}
