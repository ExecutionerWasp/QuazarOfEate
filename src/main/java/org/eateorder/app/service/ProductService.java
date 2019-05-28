package org.eateorder.app.service;

import org.eateorder.app.model.Product;

import java.util.List;

/**
 * @author Alvin
 **/
public interface ProductService {

    Product save(Product product);

    void delete(Product product);

    List<Product> findAll();

    Product findById(long id);

    void deleteById(String id);
}
