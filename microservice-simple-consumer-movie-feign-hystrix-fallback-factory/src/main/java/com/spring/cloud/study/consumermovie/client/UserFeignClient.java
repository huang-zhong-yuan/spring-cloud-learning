package com.spring.cloud.study.consumermovie.client;

import com.spring.cloud.study.consumermovie.config.FeignClientFallback;
import com.spring.cloud.study.consumermovie.entity.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "microservice-provider-user", fallback = FeignClientFallback.class)
public interface UserFeignClient {
  @GetMapping(value = "/{id}")
  User findById(@PathVariable("id") Long id);
}

@Component
@Slf4j
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

  @Override
  public UserFeignClient create(Throwable throwable) {
    return new UserFeignClient() {
      @Override
      public User findById(Long id) {
        log.info("fallback; reason was:", throwable);
        return new User(-1l, "default user", "默认用户");
      }
    };
  }
}