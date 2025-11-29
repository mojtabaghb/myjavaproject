package com.tata.myjavaproject.controller;

import com.tata.myjavaproject.entity.Product;
import com.tata.myjavaproject.entity.ProductDto;
import com.tata.myjavaproject.entity.ProductType;
import com.tata.myjavaproject.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping(value = "/add")
    @Operation(summary  = "درج رکورد در دیتابیس")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/update")
    @Operation(summary  = "آپدیت رکورد در دیتابیس")
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/find-by-id/{id}")
    @Operation(summary  = "جستجو رکورد در دیتابیس")
    public ResponseEntity<Product> getById(@PathVariable (name = "id") Long id) {
       Product product= productService.getById(id);
        return ResponseEntity.ok(product);

    }

    @GetMapping("/delete-by-id/{id}")
    @Operation(summary =  "حذف رکورد در دیتابیس")
    public ResponseEntity<Void> deleteById(@PathVariable (name = "id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping (value = "/find-all")
    @Operation(summary  = "جستجو کامل رکوردها در دیتابیس")
    public ResponseEntity<List<Product>> findAllProduct() {
       List<Product> products= productService.getAllByPage();
         return ResponseEntity.ok(products);

    }

    @GetMapping (value = "/pagination/{page}/{size}")
    @Operation(summary  = "صفحه بندی جستجو رکورد در دیتابیس")
    public ResponseEntity<Page<Product>> paginateProduct(@PathVariable(name="page")int page,@PathVariable(name="size")int size) {
        Page<Product> productPage= productService.getProductByPage(page,size);
        return ResponseEntity.ok(productPage);

    }

    @GetMapping (value = "/find-all/date-range/{startDate}/{endDate}")
    @Operation(summary  = "جستجو کامل رکوردها در دیتابیس بر اساس تاریخ")
    public ResponseEntity<List<Product>> findAllByDate(@PathVariable (name= "startDate") LocalDate startDate, @PathVariable (name= "endDate") LocalDate endDate) {
        List<Product> products= productService.getAllByDate(startDate,endDate);
        return ResponseEntity.ok(products);

    }

    @GetMapping (value = "/find-by-ProductType/{ProductType}")
    @Operation(summary  = "جستجو کامل رکوردها در دیتابیس بر اساس نوع کالا")
    public ResponseEntity<List<Product>> findAllByProductType(@PathVariable (name= "ProductType") ProductType productType) {
        List<Product> products= productService.getAllByProductType(productType);
        return ResponseEntity.ok(products);

    }



}
