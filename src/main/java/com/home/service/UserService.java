package com.home.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.dto.UserDto;
import com.home.entity.AddressEntity;
import com.home.entity.UserEntity;

import com.home.mapper.UserMapper;
import com.home.repo.AddressRepository;
import com.home.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    private final UserMapper userMapper;

    private final ObjectMapper objectMapper;

    public UserService(UserRepository userRepository, AddressRepository addressRepository, UserMapper userMapper, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userMapper = userMapper;
        this.objectMapper = objectMapper;
    }

    public UserDto getUserById(int id) {
        UserEntity userEntity = userRepository.findById((long) id).orElse(null);
        if (userEntity == null) {
            return null;
        }
        return userMapper.toDto(userEntity);
    }

    public UserDto createUser(UserDto user) {
        UserEntity userEntity = userMapper.toEntity(user);
        userEntity.setCreatedDate(Instant.now());
        //  IMPORTANT: set back-reference for each address
        if (userEntity.getAddresses() != null) {
            for (AddressEntity address : userEntity.getAddresses()) {
                address.setUser(userEntity);
            }
        }
        // Save user (addresses will be cascaded)
        UserEntity saved = userRepository.save(userEntity);
        return userMapper.toDto(saved);
    }
}