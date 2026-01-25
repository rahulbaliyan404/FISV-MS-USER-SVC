package com.home.service;

import com.home.dto.PermissionsDto;
import com.home.entity.PermissionEntity;
import com.home.mapper.PermissionsMapper;
import com.home.repo.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    private final PermissionsMapper permissionsMapper;

    public PermissionService(PermissionsMapper permissionsMapper, PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
        this.permissionsMapper = permissionsMapper;
    }

    public PermissionsDto createPermission(String name, String description) {

        permissionRepository.findByPermissionName(name)
                .ifPresent(p -> { throw new RuntimeException("Permission already exists"); });

        PermissionEntity p = new PermissionEntity();
        p.setPermissionName(name);
        p.setDescription(description);
        PermissionEntity saved = permissionRepository.save(p);

        return permissionsMapper.toDto(saved);
    }
}
