package com.example.ECommerceWishLists.Dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {

    int ProductId;

    String productName;

    double price;

}
