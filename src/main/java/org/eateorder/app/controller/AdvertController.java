package org.eateorder.app.controller;

import org.eateorder.app.model.Product;
import org.eateorder.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/advert/list")
    public List<Product> products(){
        return productService.findAll();
    }
}