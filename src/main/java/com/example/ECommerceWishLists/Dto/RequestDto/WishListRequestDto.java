package com.example.ECommerceWishLists.Dto.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WishListRequestDto {

    int wishListId;

    String wishListName;

    long username;

    String password;

    int productId;
}
