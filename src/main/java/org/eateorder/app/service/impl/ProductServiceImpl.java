package org.eateorder.app.service.impl;

import org.eateorder.app.model.Product;
import org.eateorder.app.repos.ProductRepos;
import org.eateorder.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alvin
 **/
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepos productRepos;

    @Autowired
    public ProductServiceImpl(ProductRepos productRepos) {
        this.productRepos = productRepos;
    }

    @Override
    public Product save(Product product) {
        return productRepos.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepos.delete(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepos.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepos.findById(id);
    }

    @Override
    public void deleteById(String id) {

    }
}
