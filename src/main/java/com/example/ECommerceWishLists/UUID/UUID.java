package com.example.ECommerceWishLists.UUID;

import java.util.Random;

public class UUID {
    public static int uid(){
        Random random = new Random();
        return random.nextInt(20000000);
    }
}