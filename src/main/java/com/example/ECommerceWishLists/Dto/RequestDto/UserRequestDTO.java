package com.example.ECommerceWishLists.Dto.RequestDto;

import com.example.ECommerceWishLists.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO {

    String name;

    String address;

    String password;

    String emailId;

    long mobileNo;

    int age;

    long userName;

    Gender gender;

}