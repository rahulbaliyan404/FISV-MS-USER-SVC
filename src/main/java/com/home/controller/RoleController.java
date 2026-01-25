package com.home.controller;

import com.home.dto.RolesDto;
import com.home.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private RoleService roleService;

    @PostMapping
    public RolesDto create(@RequestBody RolesDto rolesDto) {
        return roleService.createRole(rolesDto);
    }
}
