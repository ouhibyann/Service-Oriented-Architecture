package com.esipe.ms.controller;

import com.esipe.ms.model.Product;
import com.esipe.ms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/products/{label}", method = RequestMethod.GET)
    public Product getOne(@PathVariable String label) {
        return productRepository.getOne(label);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAll() {

        return productRepository.getAll();
    }


}
