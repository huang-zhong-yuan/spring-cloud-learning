package com.spring.cloud.study.consumermovie.controller;

import com.spring.cloud.study.consumermovie.client.UserFeignClient;
import com.spring.cloud.study.consumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
  
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private UserFeignClient userFeignClient;
  
  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    return this.userFeignClient.findById(id);
  }
}
