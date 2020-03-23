package com.esipe.ms.repository;

import com.esipe.ms.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    private static Map<String, Product> products = new HashMap<>();

    static {
        products.put("product1", new Product(1,"PC Portable",350));
        products.put("product2", new Product(2,"plateau de jeu", 25));
        products.put("product3", new Product(3,"clavier", 60));
    }

    public List<Product> getAll() {
        return new ArrayList<Product>(products.values());
    }

    public Product getOne(String label) {

        return products.get(label);
    }

    private boolean ifExist(String label){
        return products.containsKey(label);
    }

}


