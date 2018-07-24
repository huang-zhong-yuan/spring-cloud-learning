package com.spring.cloud.study.consumermovie.client;

import com.spring.cloud.study.consumermovie.configuration.FeignConfiguration;
import com.spring.cloud.study.consumermovie.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {
  /*@GetMapping(value = "/{id}")
  User findById(@PathVariable("id") Long id);*/
  @RequestLine("GET /{id}")
  User findById(@Param("id") Long id);
}
