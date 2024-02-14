package com.example.ECommerceWishLists.Controller;


import com.example.ECommerceWishLists.Dto.RequestDto.WishListRequestDto;
import com.example.ECommerceWishLists.Model.WishList;
import com.example.ECommerceWishLists.Service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/wishlists")
public class WishListController {
    @Autowired
    private WishListService wishListService;

    @PostMapping("/create")
    public ResponseEntity createWishList(@RequestBody WishListRequestDto wishListRequestDto) {
        ResponseEntity responseEntity = wishListService.createWishList(wishListRequestDto);
        return new ResponseEntity<>(responseEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{wishListId}/{username}/{password}")
    public ResponseEntity getWishListById(@PathVariable int wishListId, @PathVariable long username, @PathVariable String password) {
        ResponseEntity responseEntity = wishListService.getWishListById(wishListId, username, password);
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    @GetMapping("/allList")
    public ResponseEntity getAllWishListsByUserId(@RequestBody WishListRequestDto wishListRequestDto) {
        ResponseEntity responseEntity = wishListService.getAllWishListsByUserId(wishListRequestDto.getUsername(), wishListRequestDto.getPassword());
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity addProductToWishList(@RequestBody WishListRequestDto wishListRequestDto) {
        ResponseEntity responseEntity = wishListService.addProductToWishList(wishListRequestDto);
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity deleteWishList(@RequestBody WishListRequestDto wishListRequestDto) {
//        ResponseEntity responseEntity = wishListService.deleteWishList(wishListRequestDto);
//        return new ResponseEntity<>(responseEntity, HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("/delete")
    public ResponseEntity DeleteWishList(@RequestBody WishListRequestDto wishListRequestDto){
        ResponseEntity responseEntity = wishListService.DeleteWishList(wishListRequestDto);
        return new ResponseEntity<>(responseEntity, HttpStatus.ACCEPTED);
    }
}
