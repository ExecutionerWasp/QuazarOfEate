package org.eateorder.app.controller;

import org.eateorder.app.model.Advert;
import org.eateorder.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alvin
 **/

@RestController
public class AdvertController {

    private final ProductService productService;

    @Autowired
    public AdvertController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/advert/list")
    public List<Advert> products(){
        return productService.findAll();
    }

    @PostMapping("/advert/save")
    public void saveAdvert(@RequestBody Advert advert) {
        if (advert != null){
            productService.save(advert);
        }
    }

    @PostMapping("/advert/clear")
    public void clearAdverts(){
        productService.findAll().forEach(productService::delete);
    }
}