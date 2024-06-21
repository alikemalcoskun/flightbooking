package com.alikemal.flightbooking.user;

import com.alikemal.flightbooking.registration.RegUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User getUserById(Long id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    User save(RegUser user);
    void enableUser(String username);


    // TODO: Delete, Update...
}
