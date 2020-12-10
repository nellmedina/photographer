package com.poc.photographer.controller;

import com.poc.photographer.model.UserEntity;
import com.poc.photographer.service.IUserService;
import com.poc.photographer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController
{
    private IUserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getUsers()
    {
        return userService.getUsers();
    }
}
