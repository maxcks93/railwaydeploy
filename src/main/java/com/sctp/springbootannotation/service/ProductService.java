package com.sctp.springbootannotation.service;

import com.sctp.springbootannotation.model.Product;

import java.util.Collection;

public interface ProductService {
    public abstract void createProduct(Product product);
    public abstract void updateProduct(String id, Product product);
    public abstract void deleteProduct(String id);
    public abstract Collection<Product> getProducts();

    // How do I get a product by ID
    public abstract Product getProduct(String id);
}
