package com.github.mmalaquiasdev.chocolatestore.category;

import com.github.mmalaquiasdev.chocolatestore.product.Product;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Category implements Serializable {

    @Id @GeneratedValue
    private Integer id;
    @NotBlank
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

    public List<Product> addProduct(Product product) {
        if(products == null) products = new ArrayList<>();
        products.add(product);
        return products;
    }
}
