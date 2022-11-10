package com.ratana.jfx.service;

import com.ratana.jfx.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
}
