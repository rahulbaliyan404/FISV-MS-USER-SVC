package com.home.controller;

import com.home.dto.PermissionsDto;
import com.home.service.PermissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    public PermissionsDto create(@RequestBody PermissionsDto req) {
        return permissionService.createPermission(
                req.getPermissionName(), req.getDescription());
    }
}
