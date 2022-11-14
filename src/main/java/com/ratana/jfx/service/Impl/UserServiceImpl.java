package com.ratana.jfx.service.Impl;

import com.ratana.jfx.exception.ResourceNotFoundException;
import com.ratana.jfx.model.User;
import com.ratana.jfx.repository.UserRepository;
import com.ratana.jfx.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("User", id.toString()));
    }
}
