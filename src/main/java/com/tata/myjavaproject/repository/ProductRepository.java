package com.tata.myjavaproject.repository;

import com.tata.myjavaproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByRequestDateBetween(LocalDate startDate, LocalDate endDate);

}
