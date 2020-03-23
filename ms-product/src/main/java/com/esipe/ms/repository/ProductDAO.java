package com.esipe.ms.repository;

import com.esipe.ms.model.Product;

import java.util.List;

public interface ProductDAO {

    public List<Product> getAll();
    public Product getOne(int id);
    public void save(Product product);


}
