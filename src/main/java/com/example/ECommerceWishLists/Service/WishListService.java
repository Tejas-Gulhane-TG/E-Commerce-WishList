package com.example.ECommerceWishLists.Service;

import com.example.ECommerceWishLists.Dto.RequestDto.WishListRequestDto;
import org.springframework.http.ResponseEntity;


public interface WishListService {
    ResponseEntity createWishList(WishListRequestDto wishListRequestDto);

    ResponseEntity getWishListById(int wishListId, long username, String password);

    ResponseEntity getAllWishListsByUserId(Long userId, String password);

    ResponseEntity addProductToWishList(WishListRequestDto wishListRequestDto);

    ResponseEntity DeleteWishList(WishListRequestDto wishListRequestDto);

//    ResponseEntity deleteWishList(WishListRequestDto wishListRequestDto);
}
