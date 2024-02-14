package com.example.ECommerceWishLists.Repository;

import com.example.ECommerceWishLists.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByMobileNo(long mobileNo);
    User findByEmailId(String emailId);
}
