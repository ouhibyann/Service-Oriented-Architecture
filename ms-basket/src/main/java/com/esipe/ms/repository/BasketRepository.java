package com.esipe.ms.repository;

import com.esipe.ms.model.Basket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BasketRepository {

    private Map<Integer, Basket> baskets = new HashMap<>();

    public void save(Basket basket) {

        baskets.put(basket.getBasketId(), basket);
    }

    public void update(Basket basket){

        if(!ifExist(basket.getBasketId())){
            throw new RuntimeException("basket not found");
        }

        baskets.put(basket.getBasketId(), basket);
    }

    public void delete(int id) {

        if(!ifExist(id)) {
            throw new RuntimeException("basket not found");
        }

        baskets.remove(id);
    }

    public Basket getOne(int basketId){

        return baskets.get(basketId);
    }

    private boolean ifExist(int basketId){
        return baskets.containsKey(basketId);
    }

    public List<Basket> getAll() {
        return new ArrayList<Basket>(baskets.values());
    }

}
