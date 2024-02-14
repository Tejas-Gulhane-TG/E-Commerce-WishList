package com.example.ECommerceWishLists.Service;

import com.example.ECommerceWishLists.Dto.RequestDto.ProductRequestDto;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity AddProduct(ProductRequestDto productRequestDto);

    ResponseEntity GetProduct(Integer productId);

    ResponseEntity DeleteProduct(Integer productId);
}
