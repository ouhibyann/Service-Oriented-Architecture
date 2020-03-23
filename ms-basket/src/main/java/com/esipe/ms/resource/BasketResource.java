package com.esipe.ms.resource;

import com.esipe.ms.model.Basket;
import com.esipe.ms.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BasketResource {

    private BasketService basketService;

    @Autowired
    public BasketResource(BasketService basketResource) {
        this.basketService = basketResource;
    }

    @GetMapping(value = "/basket/{id}")
    public Basket getOne(@PathVariable int id) {
        return basketService.getOne(id);
    }

    @GetMapping(value = "/baskets")
    public List<Basket> getAll() {

        return basketService.getAll();
    }

    @PutMapping("{basket}")
    public void update(@PathVariable("basket") int id, @RequestBody Basket basket){

        basketService.update(basket);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id){

        basketService.delete(id);
    }

    @PostMapping
    public void add(@RequestBody Basket basket){

        basketService.add(basket);
    }
}
