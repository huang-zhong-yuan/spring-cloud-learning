package com.spring.cloud.study.consumermovie.client;

import com.spring.cloud.study.consumermovie.config.FeignDisableHystrixConfiguration;
import com.spring.cloud.study.consumermovie.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 如果全局禁用：feign.hystrix.enabled: false
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignDisableHystrixConfiguration.class)
public interface UserFeignClient {
  @GetMapping(value = "/{id}")
  User findById(@PathVariable("id") Long id);
}

