package me.dio.controller;

import me.dio.domain.User;
import me.dio.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User user = userService.findById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) throws IllegalAccessException {

        User userCreated = userService.create(user);
        return ResponseEntity.status(201).body(userCreated);
    }

}
