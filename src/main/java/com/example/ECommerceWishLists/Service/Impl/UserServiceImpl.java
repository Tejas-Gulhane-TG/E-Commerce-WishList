package com.example.ECommerceWishLists.Service.Impl;

import com.example.ECommerceWishLists.Dto.RequestDto.UserRequestDTO;
import com.example.ECommerceWishLists.Dto.ResponseDto.UserResponseDto;
import com.example.ECommerceWishLists.Model.User;
import com.example.ECommerceWishLists.Repository.UserRepository;
import com.example.ECommerceWishLists.Security.Config;
import com.example.ECommerceWishLists.Service.UserService;
import com.example.ECommerceWishLists.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


//User Service IMPL Api Add_New_User, Get_User, Delete_User Implement Api.
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override  // Create New User
    public ResponseEntity AddUser(UserRequestDTO userRequestDTO) {
        User user = userRepository.findByMobileNo(userRequestDTO.getMobileNo());
        User user1 = userRepository.findByEmailId(userRequestDTO.getEmailId());
        if(user != null)
            return new ResponseEntity<>("Mobile No already exist", HttpStatus.NOT_ACCEPTABLE);

        if(user1 != null)
            return new ResponseEntity<>("EmailId already exist", HttpStatus.NOT_ACCEPTABLE);

        User user2 = UserTransformer.DtoToUser(userRequestDTO);
        userRepository.save(user2);
        UserResponseDto userResponseDto = UserTransformer.UserToDto(user2);
        return new ResponseEntity<>("New User Added \n"+userResponseDto, HttpStatus.CREATED);
    }


    @Override  // Get User By UserName And Password
    public ResponseEntity GetUser(UserRequestDTO userRequestDTO) {
        User user = userRepository.findByMobileNo(userRequestDTO.getUserName());
        if(user != null){
            if(Config.matches(userRequestDTO.getPassword(), user.getPassword())){
                UserResponseDto userResponseDto = UserTransformer.UserToDto(user);
                return new ResponseEntity<>(userResponseDto, HttpStatus.FOUND);
            }
            return new ResponseEntity<>("Wrong password  ", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("UserName not found", HttpStatus.NOT_FOUND);
    }


    @Override //Delete User Using Username and Password
    public ResponseEntity DeleteUser(UserRequestDTO userRequestDTO) {
        User user = userRepository.findByMobileNo(userRequestDTO.getUserName());
        if(user != null){
            if(Config.matches(userRequestDTO.getPassword(), user.getPassword())){
                userRepository.delete(user);
                return new ResponseEntity<>("User deleted Successfully", HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Wrong password  ", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("UserName not found", HttpStatus.NOT_FOUND);
    }
}
