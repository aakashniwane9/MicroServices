package com.micro.user.controller;

import com.micro.user.VO.ResponseTemplateVO;
import com.micro.user.entity.User;
import com.micro.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("inside saveUser -> UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/user")
    public ResponseTemplateVO getUserWithDepartment(@RequestParam(value = "id") Long userId) {
        log.info("inside getUserWithDepartment -> UserController");
        return userService.getUserWithDepartment(userId);


    }


}
