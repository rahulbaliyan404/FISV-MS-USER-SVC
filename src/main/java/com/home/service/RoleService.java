package com.home.service;

import com.home.dto.PermissionsDto;
import com.home.dto.RolesDto;
import com.home.entity.PermissionEntity;
import com.home.entity.RolesEntity;
import com.home.mapper.RolesMapper;
import com.home.repo.PermissionRepository;
import com.home.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    private final RolesMapper rolesMapper;

    public RoleService(RolesMapper rolesMapper) {
        this.rolesMapper = rolesMapper;
    }

    public RolesDto createRole(RolesDto rolesDto) {

        roleRepository.findByRoleName(rolesDto.getName())
                .ifPresent(r -> { throw new RuntimeException("Role already exists"); });

       Set<PermissionsDto> permissionNames = rolesDto.getPermissions();
       Set<PermissionEntity> permissions = permissionRepository.findByPermissionNameIn(permissionNames);

        if (permissions.size() != permissionNames.size()) {
            throw new RuntimeException("Some permissions not found");
        }
        RolesEntity role = rolesMapper.toEntity(rolesDto);
        role.setPermissions(permissions);
        RolesEntity savedRole = roleRepository.save(role);

        return rolesMapper.toDto(savedRole);
    }
}
