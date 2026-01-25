package com.home.repo;

import com.home.dto.PermissionsDto;
import com.home.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
    Set<PermissionEntity> findByPermissionNameIn(Set<PermissionsDto> names);
    Optional<PermissionEntity> findByPermissionName(String name);
}
