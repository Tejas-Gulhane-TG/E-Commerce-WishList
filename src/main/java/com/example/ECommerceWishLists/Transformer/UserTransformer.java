package com.example.ECommerceWishLists.Transformer;

import com.example.ECommerceWishLists.Dto.RequestDto.UserRequestDTO;
import com.example.ECommerceWishLists.Dto.ResponseDto.UserResponseDto;
import com.example.ECommerceWishLists.Model.User;
import com.example.ECommerceWishLists.Security.Config;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserTransformer {

    public static User DtoToUser(UserRequestDTO userRequestDTO){

        String password = Config.encode(userRequestDTO.getPassword());
        return User.builder()
                .userName(userRequestDTO.getMobileNo())
                .age(userRequestDTO.getAge())
                .password(password)
                .name(userRequestDTO.getName())
                .address(userRequestDTO.getAddress())
                .emailId(userRequestDTO.getEmailId())
                .gender(userRequestDTO.getGender())
                .mobileNo(userRequestDTO.getMobileNo())
                .build();
    }

    public static UserResponseDto UserToDto(User user){
        return UserResponseDto.builder()
                .name(user.getName())
                .userName(user.getMobileNo())
                .address(user.getAddress())
                .emailId(user.getEmailId())
                .age(user.getAge())
                .gender(user.getGender())
                .mobileNo(user.getMobileNo())
                .build();
    }
}
