package com.example.ECommerceWishLists.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

//Product Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String productName;

    @Column(nullable = false, unique = true)
    int productUId;

    @Column(nullable = false)
    double price;

    @ManyToMany(mappedBy = "productList", cascade = CascadeType.ALL)
    List<WishList> wishListList = new ArrayList<>();

}
