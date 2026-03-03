package com.vg.nagp.ecomm.catalog_api.repository;


import com.vg.nagp.ecomm.catalog_api.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Products, String> {
    // find products by sellerId
    List<Products> findBySellerId(String sellerId);
}
