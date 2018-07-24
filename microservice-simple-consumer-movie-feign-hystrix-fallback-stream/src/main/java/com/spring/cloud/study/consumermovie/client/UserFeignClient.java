package com.spring.cloud.study.consumermovie.client;

import com.spring.cloud.study.consumermovie.config.FeignClientFallback;
import com.spring.cloud.study.consumermovie.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "microservice-provider-user", fallback = FeignClientFallback.class)
public interface UserFeignClient {
  @GetMapping(value = "/{id}")
  User findById(@PathVariable("id") Long id);
}
