package com.home.mapper;

import com.home.dto.RolesDto;
import com.home.entity.RolesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolesMapper {

    RolesEntity toEntity(RolesDto permissionsDto);

    RolesDto toDto(RolesEntity permissionEntity);
}
