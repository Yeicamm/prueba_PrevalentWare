package com.prueba.prevalentware.controller;

import com.prueba.prevalentware.entity.User;
import com.prueba.prevalentware.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    /**
    @GetMapping("/{roleId}")
    public User getUserByEmail(@PathVariable String roleId) {
        return userService.(roleId);
    }**/

    @GetMapping("/{roleId}")
    public List<User> getUserByEmail(@PathVariable String roleId) {
        return userService.getUserRol(roleId);
    }

}
