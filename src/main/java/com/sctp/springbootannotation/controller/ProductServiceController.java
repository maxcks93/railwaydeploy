package com.sctp.springbootannotation.controller;

import com.sctp.springbootannotation.model.Product;
import com.sctp.springbootannotation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductServiceController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Object> welcome() {
        return new ResponseEntity<>("Your application is running", HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    // How do I get a product by ID
    @GetMapping("/product/{id}")
    public ResponseEntity<Object> getSingleProduct(@PathVariable("id") String id){
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully!!", HttpStatus.CREATED);
    }
}
