package org.eateorder.app.repos;

import org.eateorder.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alvin
 **/
@Repository
public interface ProductRepos extends JpaRepository<Product, Long> {
    Product findById(long id);

    void deleteById(long id);
}
