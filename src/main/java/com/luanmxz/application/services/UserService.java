package com.luanmxz.application.services;

import java.util.UUID;

import com.luanmxz.domain.model.User;

public class UserService {

  public User findById(String id) {
    String randomName = UUID.randomUUID().toString();

    // always "finds" the user, every user has a random name
    return new User(id, randomName);
  }

}
