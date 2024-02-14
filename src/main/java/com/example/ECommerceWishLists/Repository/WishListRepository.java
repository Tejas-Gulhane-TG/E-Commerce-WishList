package com.example.ECommerceWishLists.Repository;

import com.example.ECommerceWishLists.Model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> findAllByUserId(Long userId);
    WishList findByWishListId(int id);

}
