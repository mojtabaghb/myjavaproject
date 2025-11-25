package com.tata.myjavaproject.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

public class ProductDto {
    private  String name;
    private  String product_city;
    private  ProductType product_type;
    private Long price;
    private LocalDate date;
}
