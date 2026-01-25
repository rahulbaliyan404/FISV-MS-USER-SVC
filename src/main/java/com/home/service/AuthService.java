package com.home.service;

import com.home.dto.AuthPayload;
import com.home.entity.RolesEntity;
import com.home.entity.UserEntity;
import com.home.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthPayload validateUser(String username, String password) {
        UserEntity user = userRepository.findByEmail(username);
        if (user == null) {
            throw new RuntimeException("Invalid credentials");
        }

       if (!passwordEncoder.matches(password, user.getPassword())) {
           // fallback to plain-text comparison if stored password is not encoded
           if (!password.equals(user.getPassword())) {
               throw new RuntimeException("Invalid credentials");
           }
       }

        return new AuthPayload(
                user.getId(),
                user.getFirstName() + " " + user.getLastName(),
                user.getEmail(),
                user.getRoles().stream().map(RolesEntity::getRoleName)
                        .collect(java.util.stream.Collectors.toList())
        );
    }
}
