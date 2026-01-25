package com.home.controller;

import com.home.service.UserRoleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRoleController {
    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping("/{id}/roles/{roleName}")
    public String assignRole(@PathVariable Long id,
                             @PathVariable String roleName) {

        userRoleService.assignRoleToUser(id, roleName);
        return "Role assigned successfully";
    }
}
