package org.eateorder.app.controller;

import org.eateorder.app.exception.NotFoundException;
import org.eateorder.app.model.Advert;
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

    private final List<Advert> basket = new ArrayList<>();


    @PostMapping("/basket/list")
    public List<Advert> basketList() {
        return this.basket;
    }

    @PostMapping("basket/clear")
    public List<Advert> basketClear() {
        basket.clear();
        return basket;
    }

    @PostMapping("basket/add")
    public void addToBasket(@RequestBody Advert advert) throws NotFoundException {
        if (advert != null) {
            basket.add(advert);
        } else {
            throw new NotFoundException();
        }
    }
}
