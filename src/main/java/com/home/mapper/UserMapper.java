package com.home.mapper;

import com.home.dto.UserDto;
import com.home.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDto user);

    UserDto toDto(UserEntity entity);
}
