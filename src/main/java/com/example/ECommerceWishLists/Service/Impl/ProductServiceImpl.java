package com.example.ECommerceWishLists.Service.Impl;

import com.example.ECommerceWishLists.Dto.RequestDto.ProductRequestDto;
import com.example.ECommerceWishLists.Dto.ResponseDto.ProductResponseDto;
import com.example.ECommerceWishLists.Model.Product;
import com.example.ECommerceWishLists.Repository.ProductRepository;
import com.example.ECommerceWishLists.Service.ProductService;
import com.example.ECommerceWishLists.Transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


//Product Service IMPl
// Add_Product,
// Get_Product,
// Delete_Product Implement Api.
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity AddProduct(ProductRequestDto productRequestDto) {
        Product product = ProductTransformer.DtoToProduct(productRequestDto);
        productRepository.save(product);
        ProductResponseDto productResponseDto = ProductTransformer.ProductToDto(product);
        return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity GetProduct(Integer productId) {
        Product product = productRepository.findByproductUId(productId);
        if(product != null){
            ProductResponseDto productResponseDto = ProductTransformer.ProductToDto(product);
            return new ResponseEntity<>(productResponseDto, HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity DeleteProduct(Integer productId) {
        Product product = productRepository.findByproductUId(productId);
        if(product != null){
            productRepository.delete(product);
            return new ResponseEntity<>("Product delete successfully", HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}
