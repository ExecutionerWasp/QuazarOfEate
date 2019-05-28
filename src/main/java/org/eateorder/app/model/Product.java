package org.eateorder.app.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alvin
 **/

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private double price;
    private String imgUrl;

    @JoinColumn(name = "product_type_id")
    @OneToMany(fetch = FetchType.EAGER)
    private List<ProductType> productType;

    public Product() {
    }

    public Product(String name, String description, double price, String imgUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
