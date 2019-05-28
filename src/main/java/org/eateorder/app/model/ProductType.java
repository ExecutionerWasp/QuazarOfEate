package org.eateorder.app.model;

import javax.persistence.*;

/**
 * @author Alvin
 **/
@Entity
@Table(name = "product_types")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public ProductType() {
    }

    public ProductType(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
