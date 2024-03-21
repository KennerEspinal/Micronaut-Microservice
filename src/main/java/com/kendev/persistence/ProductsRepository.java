package com.kendev.persistence;

import com.kendev.entity.Product;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ProductsRepository extends CrudRepository<Product, String> {
}
