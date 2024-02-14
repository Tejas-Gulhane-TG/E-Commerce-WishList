package com.example.ECommerceWishLists.Transformer;

import com.example.ECommerceWishLists.Dto.RequestDto.ProductRequestDto;
import com.example.ECommerceWishLists.Dto.ResponseDto.ProductResponseDto;
import com.example.ECommerceWishLists.Model.Product;
import com.example.ECommerceWishLists.UUID.UUID;

public class ProductTransformer {

    public static Product DtoToProduct(ProductRequestDto productRequestDto){
        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .productUId(UUID.uid())
                .build();
    }

    public static ProductResponseDto ProductToDto(Product product){
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .ProductId(product.getProductUId())
                .build();
    }
}
