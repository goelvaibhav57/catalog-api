package com.vg.nagp.ecomm.catalog_api.controller;

import com.vg.nagp.ecomm.catalog_api.model.Products;
import com.vg.nagp.ecomm.catalog_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Get all products from MongoDB
     *
     * @return ResponseEntity containing list of all products
     */
    @GetMapping("/all")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    /**
     * Get a product by ID
     *
     * @param id the product ID
     * @return ResponseEntity containing the product if found
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<Products>> getProductById(@PathVariable String id) {
        List<Products> products = productService.getProductBySellerId(id);
        if (products == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    /**
     * Create a new product
     *
     * @param product the product to create
     * @return ResponseEntity containing the created product
     */
    @PostMapping("/create")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        Products createdProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    /**
     * Update an existing product
     *
     * @param id the product ID
     * @param product the updated product data
     * @return ResponseEntity containing the updated product
     */
    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable String id, @RequestBody Products product) {
        Products existingProduct = productService.getProductById(id);
        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }
        product.setId(id);
        Products updatedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * Delete a product by ID
     *
     * @param id the product ID
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        Products existingProduct = productService.getProductById(id);
        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Get service status
     *
     * @return ResponseEntity containing service status information
     */
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("service", "catalog-api");
        status.put("status", "UP");
        status.put("timestamp", LocalDateTime.now());
        status.put("version", "1.0.0");

        return ResponseEntity.ok(status);
    }
}
