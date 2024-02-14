package com.example.ECommerceWishLists.Model;

import com.example.ECommerceWishLists.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

//User Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;

    @Column(nullable = false, unique = true)
    String emailId;

    String address;

    long userName;

    @Column(nullable = false)
    String password;

    @Column(unique = true, nullable = false)
    long mobileNo;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "wishListName", cascade = CascadeType.ALL)
    List<WishList> wishListList = new ArrayList<>();

}
