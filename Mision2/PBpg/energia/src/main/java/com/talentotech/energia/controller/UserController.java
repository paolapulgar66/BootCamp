package com.talentotech.energia.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentotech.energia.model.User;
import com.talentotech.energia.repository.UserRepository;

@RestController
@RequestMapping("/api/users")

public class UserController {
private final UserRepository userRepository;
public UserController(UserRepository userRepository) {
this.userRepository = userRepository;
}
@PostMapping
public User create (@RequestBody User user) {

return userRepository.save(user);
}
@GetMapping
public List<User> finDALL() {
return userRepository.findAll();
}

}


