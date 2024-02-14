package com.example.ECommerceWishLists.Dto.ResponseDto;

import com.example.ECommerceWishLists.Model.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WishListResponseDto {

    String WishListName;

    List<Product> productList = new ArrayList<>();
}
