package com.example.ECommerceWishLists.Service;

import com.example.ECommerceWishLists.Dto.RequestDto.UserRequestDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity AddUser(UserRequestDTO userRequestDTO);

    ResponseEntity GetUser(UserRequestDTO userRequestDTO);

    ResponseEntity DeleteUser(UserRequestDTO userRequestDTO);
}
