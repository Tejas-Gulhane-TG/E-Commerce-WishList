package com.example.ECommerceWishLists.Repository;

import com.example.ECommerceWishLists.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByproductUId(int id);

}
