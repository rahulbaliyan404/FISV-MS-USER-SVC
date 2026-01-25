package com.home.service;

import com.home.entity.RolesEntity;
import com.home.entity.UserEntity;
import com.home.repo.RoleRepository;
import com.home.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserRoleService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void assignRoleToUser(Long userId, String roleName) {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        RolesEntity role = roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Set<RolesEntity> roles = user.getRoles();
        if (roles == null) {
            roles = new HashSet<>();
            user.setRoles(roles);
        }
        roles.add(role);

        userRepository.save(user);
    }
}
