package com.talentotech.energia.controller;
import com.talentotech.energia.model.User;
import com.talentotech.energia.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
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
// READ BY ID
@GetMapping("/{id}")
public User findById(@PathVariable Long id) {
    return userRepository.findById(id).orElseThrow(() 
    -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

}
//UPDATE
@PutMapping("/{id}")
public User update(@PathVariable Long id, @RequestBody User userDetails) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    user.setUsername(userDetails.getUsername());
    user.setEmail(userDetails.getEmail());

    return userRepository.save(user);
}

} 