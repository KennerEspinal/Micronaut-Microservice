package com.kendev.controller;

import com.kendev.Services.ProductsServices;
import com.kendev.entity.Product;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

import javax.xml.namespace.QName;

@Controller("/microservice-products")
@Tag(name = "products")
public class MicroserviceProductsController {

    @Inject
    ProductsServices ps;

    @Get(uri = "/")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Product> getProducts() {
        return ps.getProducts();
    }

    @Post(uri = "/product")
    @Produces(MediaType.APPLICATION_JSON)
    public Product saveProduct(@Body Product product) {
        return ps.saveOrUpdate(product);
    }

    @Put(uri = "/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product updateProduct(@PathVariable String id, @Body Product product) {
        return ps.saveOrUpdate(product);
    }

    @Delete(uri = "/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteProduct(@PathVariable String id) {
        ps.delete(id);
    }
}