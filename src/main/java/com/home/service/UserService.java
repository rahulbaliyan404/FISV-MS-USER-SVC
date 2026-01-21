package com.home.service;

import com.home.UserRepository;
import com.home.dto.User;
import com.home.entity.UserEntity;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id) {
        UserEntity userEntity = userRepository.findById((long) id).orElse(null);
        if (userEntity == null) {
            return null;
        }
        // map entity to DTO
        User user = new User();
//        user.setId((int) userEntity.getId());
//        user.setName(userEntity.getName());
//        user.setEmail(userEntity.getEmail());
        return user;
    }
}