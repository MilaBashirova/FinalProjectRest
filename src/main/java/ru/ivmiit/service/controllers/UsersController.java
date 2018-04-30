package ru.ivmiit.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivmiit.service.forms.UserForm;
import ru.ivmiit.service.models.User;
import ru.ivmiit.service.repositories.UsersRepository;
import ru.ivmiit.service.services.UserService;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{user-id}")
    public User getUser(@PathVariable("user-id") Long userId) {
        return userService.findOne(userId);
    }

    @PostMapping("/addUser")
    public ResponseEntity<Object> addUser(@RequestBody UserForm userForm) {
        userService.signUp(userForm);
        return ResponseEntity.ok().build();
    }


}
