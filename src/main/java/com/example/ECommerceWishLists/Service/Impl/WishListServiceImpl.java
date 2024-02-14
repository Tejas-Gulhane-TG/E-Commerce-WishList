package com.example.ECommerceWishLists.Service.Impl;



import com.example.ECommerceWishLists.Dto.RequestDto.WishListRequestDto;
import com.example.ECommerceWishLists.Model.Product;
import com.example.ECommerceWishLists.Model.User;
import com.example.ECommerceWishLists.Model.WishList;
import com.example.ECommerceWishLists.Repository.ProductRepository;
import com.example.ECommerceWishLists.Repository.UserRepository;
import com.example.ECommerceWishLists.Repository.WishListRepository;
import com.example.ECommerceWishLists.Security.Config;
import com.example.ECommerceWishLists.Service.WishListService;;
import com.example.ECommerceWishLists.Transformer.WishListTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class WishListServiceImpl implements WishListService {
    @Autowired
    private WishListRepository wishListRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity createWishList(WishListRequestDto wishListRequestDto) {
        User user = userRepository.findByMobileNo(wishListRequestDto.getUsername());
        if(user != null){
            if(Config.matches(wishListRequestDto.getPassword(), user.getPassword())){

                WishList wishList = WishListTransformer.DtoToWishList(wishListRequestDto);
                wishList.setUser(user);
                wishListRepository.save(wishList);
                return new ResponseEntity<>(wishList.getWishListName()+"  WishListId : "+wishList.getWishListId(), HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Wrong password  ", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("UserName not found", HttpStatus.NOT_FOUND);
    }


    public ResponseEntity getWishListById(int wishListId, long username, String password) {
        User user = userRepository.findByMobileNo(username);
        if(user != null){
            if(Config.matches(password, user.getPassword())){
                WishList wishList =  wishListRepository.findByWishListId(wishListId);
                if(wishList != null){
                    List<Product> productList = wishList.getProductList();
                    List<String> list = new ArrayList<>();
                    for(int i=0; i<productList.size(); i++){
                        list.add("Product_ID :- "+productList.get(i).getProductUId()+" "+productList.get(i).getProductName());
                    }
                    return  new ResponseEntity<>(list, HttpStatus.FOUND);
                }

                return new ResponseEntity<>("WishList not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Wrong password  ", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("UserName not found", HttpStatus.NOT_FOUND);
    }


    public ResponseEntity getAllWishListsByUserId(Long username, String password) {
        User user = userRepository.findByMobileNo(username);
        if(user != null){
            if(Config.matches(password, user.getPassword())){
                List<WishList> wishLists = wishListRepository.findAllByUserId(user.getId());
                List<String> list = new ArrayList<>();
                for(int i=0; i< wishLists.size(); i++){
                    list.add(wishLists.get(i).getWishListName()+"  Id:- "+wishLists.get(i).getWishListId());
                }
                return new ResponseEntity<>(list , HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Wrong password  ", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("UserName not found", HttpStatus.NOT_FOUND);
    }


    public ResponseEntity addProductToWishList(WishListRequestDto wishListRequestDto) {
        User user = userRepository.findByMobileNo(wishListRequestDto.getUsername());
        if(user != null){
            if(Config.matches(wishListRequestDto.getPassword(), user.getPassword())){
                Product product = productRepository.findByproductUId(wishListRequestDto.getProductId());
                if(product == null ){
                    return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
                }
                WishList wishLists = wishListRepository.findByWishListId(wishListRequestDto.getWishListId());
                User user1 = wishLists.getUser();
                if(user.getId() == user1.getId()){
                    List<Product> productList = wishLists.getProductList();
                    productList.add(product);
                    wishLists.setProductList(productList);
                    wishListRepository.save(wishLists);
                    return new ResponseEntity<>(product.getProductName()+" Added to "+wishLists.getWishListName()+" wishListId :- "+wishLists.getWishListId(), HttpStatus.ACCEPTED);
                }
                return new ResponseEntity<>("Wishlist not Belong to this User", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Wrong password  ", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("UserName not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity DeleteWishList(WishListRequestDto wishListRequestDto) {
        User user = userRepository.findByMobileNo(wishListRequestDto.getUsername());
        if(user != null){
            if(Config.matches(wishListRequestDto.getPassword(), user.getPassword())){
                WishList wishList =  wishListRepository.findByWishListId(wishListRequestDto.getWishListId());
                if(wishList == null){
                    return new ResponseEntity("Wishlist not found", HttpStatus.NOT_FOUND);
                }
                if(user.getId() == wishList.getUser().getId()){
                    wishListRepository.deleteById(wishList.getId());
                    return new ResponseEntity(" Wishlist Delete successfully ", HttpStatus.ACCEPTED);
                }
                return new ResponseEntity("Wishlist not Belong to this User", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
    }



}

