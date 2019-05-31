package org.eateorder.app.service.impl;

import org.eateorder.app.model.Advert;
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
    public Advert save(Advert advert) {
        return productRepos.save(advert);
    }

    @Override
    public void delete(Advert advert) {
        productRepos.delete(advert);
    }

    @Override
    public List<Advert> findAll() {
        return productRepos.findAll();
    }

    @Override
    public Advert findById(long id) {
        return productRepos.findById(id);
    }

    @Override
    public void deleteById(String id) {

    }
}
