package com.esipe.ms.service;

import com.esipe.ms.model.Basket;
import com.esipe.ms.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public void add(Basket basket) {
        System.out.println("create a new cart");

        basketRepository.save(basket);
    }

    public Basket getOne(int id) {

        return basketRepository.getOne(id);
    }

    public void update(Basket basket) {
        System.out.println("Updating cart with the id :"+ basket.getBasketId());

        basketRepository.update(basket);
    }

    public void delete(int id) {
        System.out.println("Deleting the cart with the id :"+ basketRepository.getOne(id));

        basketRepository.delete(id);
    }

    public List<Basket> getAll() {

        return basketRepository.getAll();
    }
}
