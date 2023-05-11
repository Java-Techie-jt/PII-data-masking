package com.javatechie.service;

import com.javatechie.dto.AccountDetails;
import com.javatechie.dto.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {


    public List<User> getAllUsers() {

        User user1 = new User(3235, "john", "6474729899", "1234567890", 30, "johncn", "john123",
                List.of(new AccountDetails("JOHN CURRRAN", "365027332671", "SAVING")
                        , new AccountDetails("JOHN CURRRAN", "365027332671", "CURRENT")));

        User user2 = new User(9546, "Smith", "4623642828", "5439854674", 41, "smithkn", "smith619",
                List.of(new AccountDetails("Smith ken", "8272389200", "SAVING")));

        return Stream.of(user1, user2).collect(Collectors.toList());
    }

    public User getUser(int id) {
        return getAllUsers().stream().filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("user not found"));
    }
}
