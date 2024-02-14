package com.example.ECommerceWishLists.Transformer;

import com.example.ECommerceWishLists.Dto.RequestDto.WishListRequestDto;
import com.example.ECommerceWishLists.Model.WishList;
import com.example.ECommerceWishLists.UUID.UUID;

//WishList Transformer Data
public class WishListTransformer {
    public static WishList DtoToWishList(WishListRequestDto wishListRequestDto){
        return WishList.builder()
                .wishListName(wishListRequestDto.getWishListName())
                .wishListId(UUID.uid())
                .build();
    }
}
