package com.example.ECommerceWishLists.UUID;

import java.util.Random;

//Unique Id For data
public class UUID {
    public static int uid(){
        Random random = new Random();
        return random.nextInt(20000000);
    }
}