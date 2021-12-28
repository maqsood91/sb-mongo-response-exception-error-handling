package com.maqcoding.sbmongoresponseexceptionerrorhandling.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maqcoding.sbmongoresponseexceptionerrorhandling.model.Products;

public interface ProductRepo extends MongoRepository<Products,String>{

}
