package com.spring.could.study.provideruser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  
  private Long id;
  
  private String username;
  
  private String name;
}
