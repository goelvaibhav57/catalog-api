package com.vg.nagp.ecomm.catalog_api.service;


import com.vg.nagp.ecomm.catalog_api.model.Products;
import com.vg.nagp.ecomm.catalog_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieve all products from MongoDB
     *
     * @return List of all products
     */
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieve a product by ID
     *
     * @param id the product ID
     * @return the product if found
     */
    public Products getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Products> getProductBySellerId(String name) {
        return productRepository.findBySellerId(name);
    }

    /**
     * Save a new product
     *
     * @param product the product to save
     * @return the saved product
     */
    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }

    /**
     * Delete a product by ID
     *
     * @param id the product ID
     */
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}


