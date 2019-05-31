package org.eateorder.app.service;

import org.eateorder.app.model.Advert;

import java.util.List;

/**
 * @author Alvin
 **/
public interface ProductService {

    Advert save(Advert advert);

    void delete(Advert advert);

    List<Advert> findAll();

    Advert findById(long id);

    void deleteById(String id);
}
