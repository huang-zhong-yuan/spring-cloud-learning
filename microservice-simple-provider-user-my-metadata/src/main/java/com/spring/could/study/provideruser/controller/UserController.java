package com.spring.could.study.provideruser.controller;

import com.spring.could.study.provideruser.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  
  @GetMapping("/{id}")
  public User findUserById(@PathVariable Long id) {
    return new User(1l, "username1", "name1");
  }
  
}
