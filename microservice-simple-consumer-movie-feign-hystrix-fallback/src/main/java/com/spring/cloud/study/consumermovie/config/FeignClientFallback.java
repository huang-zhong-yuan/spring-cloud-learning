package com.spring.cloud.study.consumermovie.config;

import com.spring.cloud.study.consumermovie.client.UserFeignClient;
import com.spring.cloud.study.consumermovie.entity.User;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements UserFeignClient {
  @Override
  public User findById(Long id) {
    return new User(-1l, "default user", "默认用户");
  }
}
