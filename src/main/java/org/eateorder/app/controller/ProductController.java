package org.eateorder.app.controller;

import org.eateorder.app.exception.NotFoundException;
import org.eateorder.app.model.Product;
import org.eateorder.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alvin
 **/

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Product get(@PathVariable long id) throws NotFoundException {
        return productService.findAll()
                .stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable long id, @RequestBody Product product) throws NotFoundException {
        Product productFromDb = productService.findById(id);
        if (productFromDb != null) {
            productFromDb.setId(id);
            productFromDb.setName(product.getName());
            productFromDb.setDescription(product.getDescription());
            productFromDb.setImgUrl(product.getImgUrl());
            productFromDb.setPrice(product.getPrice());
        }else {
            throw new NotFoundException();
        }
        return productFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        productService.deleteById(id);
    }
}
