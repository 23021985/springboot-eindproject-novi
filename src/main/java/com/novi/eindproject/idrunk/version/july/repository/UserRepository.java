package com.novi.eindproject.idrunk.version.july.repository;


import com.novi.eindproject.idrunk.version.july.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {


        Optional<User> findByUsername(String  username);


    Optional<User> findById(Long drinkId);

    Optional<User> findById(User user);
}
