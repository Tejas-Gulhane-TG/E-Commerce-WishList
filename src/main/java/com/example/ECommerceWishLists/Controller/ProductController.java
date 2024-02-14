package com.example.ECommerceWishLists.Controller;

import com.example.ECommerceWishLists.Dto.RequestDto.ProductRequestDto;
import com.example.ECommerceWishLists.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//Product Controller Add_Product, Get_Product, Delete_Product Api Added.
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity AddProduct(@RequestBody ProductRequestDto productRequestDto){
        ResponseEntity responseEntity = productService.AddProduct(productRequestDto);
        return responseEntity;
    }

    @GetMapping("/get-by-productId/{productId}")
    public ResponseEntity GetProduct(@PathVariable Integer productId ){
        ResponseEntity responseEntity = productService.GetProduct(productId);
        return responseEntity;
    }

    @DeleteMapping("/delete-by-id/{productId}")
    public ResponseEntity DeleteProduct(@PathVariable Integer productId){
        ResponseEntity responseEntity = productService.DeleteProduct(productId);
        return responseEntity;
    }
}
