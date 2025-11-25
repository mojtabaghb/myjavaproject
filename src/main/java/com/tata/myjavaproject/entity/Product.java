package com.tata.myjavaproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "TBL_PRODUCT",schema="USR_FIOJI")
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USR_FIOJI.Product_seq")
    @SequenceGenerator(name = "USR_FIOJI.Product_seq", sequenceName = "product_seq", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRODUCT_CITY")
    private  String product_city;

    @Column(name = "PRODUCT_TYPE")
    private  ProductType product_type;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "REQUEST_DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate requestDate ;

}
