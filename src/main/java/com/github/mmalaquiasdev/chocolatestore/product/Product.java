package com.github.mmalaquiasdev.chocolatestore.product;

import com.github.mmalaquiasdev.chocolatestore.category.Category;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Product implements Serializable {
    @Id @GeneratedValue
    private Integer id;
    private String name;
    private BigDecimal preco;
    @ManyToMany
    @JoinTable(name = "PRODUCT_CATEGORY",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    public List<Category> addCategory(Category category) {
        if(category == null) categories = new ArrayList<>();
        categories.add(category);
        return categories;
    }
 }
