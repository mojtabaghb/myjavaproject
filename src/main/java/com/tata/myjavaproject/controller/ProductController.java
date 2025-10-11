package com.tata.myjavaproject.controller;

import com.tata.myjavaproject.entity.Product;
import com.tata.myjavaproject.entity.ProductDto;
import com.tata.myjavaproject.service.ProductService;
import lombok.AllArgsConstructor;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping(value = "/add")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Product> getById(@PathVariable (name = "id") int id) {
       Product product= productService.getById(id);
        return ResponseEntity.ok(product);

    }

    @GetMapping("/delete-by-id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable (name = "id") int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping (value = "/find-all")
    public ResponseEntity<List<Product>> findAllProduct() {
       List<Product> products= productService.getAllByPage();
        return ResponseEntity.ok(products);

    }

    @GetMapping (value = "/pagination/{page}/{size}")
    public ResponseEntity<Page<Product>> paginateProduct(@PathVariable(name="page")int page,@PathVariable(name="size")int size) {
        Page<Product> productPage= productService.getProductByPage(page,size);
        return ResponseEntity.ok(productPage);

    }



}
