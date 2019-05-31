package org.eateorder.app.repos;

import org.eateorder.app.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alvin
 **/
@Repository
public interface ProductRepos extends JpaRepository<Advert, Long> {
    Advert findById(long id);

    void deleteById(long id);
}
