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

//WishList Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String wishListName;

    @Column(unique = true)
    int wishListId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "mobileNo")
    User user;

    @ManyToMany
    @JoinTable(
            name = "wishlist_product",
            joinColumns = @JoinColumn(name = "wishListId"),
            inverseJoinColumns = @JoinColumn(name = "productUId")
    )
    List<Product> productList = new ArrayList<>();

}
