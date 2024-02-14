package com.example.ECommerceWishLists.Controller;

import com.example.ECommerceWishLists.Dto.RequestDto.UserRequestDTO;
import com.example.ECommerceWishLists.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//User Controller Added Some Api Add_New_User, Get_User, Delete_User
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity AddUser(@RequestBody UserRequestDTO userRequestDTO){
        ResponseEntity responseEntity = userService.AddUser(userRequestDTO);
        return responseEntity;
    }

    @GetMapping("/get")
    public ResponseEntity GetUser(@RequestBody UserRequestDTO userRequestDTO){
        ResponseEntity responseEntity = userService.GetUser(userRequestDTO);
        return responseEntity;
    }

    @DeleteMapping("/delete")
    public ResponseEntity DeleteUser(@RequestBody UserRequestDTO userRequestDTO){
        ResponseEntity responseEntity = userService.DeleteUser(userRequestDTO);
        return responseEntity;
    }
}
