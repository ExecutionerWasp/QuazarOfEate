package org.eateorder.app.controller;

import org.eateorder.app.exception.NotFoundException;
import org.eateorder.app.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alvin
 **/
@RestController
public class BasketController {

    private final List<Product> basket = new ArrayList<>();


    @PostMapping("/basket/list")
    public List<Product> basketList() {
        return this.basket;
    }

    @PostMapping("basket/clear")
    public List<Product> basketClear() {
        basket.clear();
        return basket;
    }

    @PostMapping("basket/add")
    public void addToBasket(@RequestBody Product product) throws NotFoundException {
        if (product != null) {
            basket.add(product);
        } else {
            throw new NotFoundException();
        }
    }
}
