package com.home.mapper;

import com.home.dto.PermissionsDto;
import com.home.entity.PermissionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionsMapper {

    PermissionEntity toEntity(PermissionsDto permissionsDto);

    PermissionsDto toDto(PermissionEntity permissionEntity);
}
