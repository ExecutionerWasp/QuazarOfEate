package org.eateorder.app.controller;

import org.eateorder.app.model.Advert;
import org.eateorder.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @GetMapping("/start")
    public String index(Model model){
        model.addAttribute("adverts", productService.findAll());
        return "templates/index.html";
    }

    @PostMapping("/advert/list")
    public List<Advert> products(){
        return productService.findAll();
    }
}