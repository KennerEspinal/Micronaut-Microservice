package com.kendev.Services;

import com.kendev.entity.Product;
import com.kendev.persistence.ProductsRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ProductsServices {
    @Inject
    ProductsRepository pr;

    public Iterable<Product> getProducts(){return pr.findAll();}

    public Product saveOrUpdate(Product product){
        Product productNew = null;
        if(product.getId() != null && pr.existsById(product.getId())){
            productNew = pr.update(product);
        }else{
            productNew = pr.save(product);
        }
        return productNew;
    }

    public void delete(String id){
        pr.deleteById(id);
    }

}
