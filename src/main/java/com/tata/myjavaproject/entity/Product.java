package com.tata.myjavaproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "TBL_PRODUCT",schema="USR_FIOJI")
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USR_FIOJI.Product_seq")
    private int id;
    private String name;
    private  String product_city;
    private  ProductType product_type;
    private Long price;

}
