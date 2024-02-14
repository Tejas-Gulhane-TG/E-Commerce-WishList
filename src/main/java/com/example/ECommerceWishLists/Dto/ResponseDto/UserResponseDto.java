package com.example.ECommerceWishLists.Dto.ResponseDto;

import com.example.ECommerceWishLists.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {

    String name;

    long userName;

    String address;

    String emailId;

    long mobileNo;

    int age;

    Gender gender;
}
