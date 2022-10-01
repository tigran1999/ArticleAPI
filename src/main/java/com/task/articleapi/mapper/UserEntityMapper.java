package com.task.articleapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.task.articleapi.dto.UserDto;
import com.task.articleapi.entity.User;

@Mapper(componentModel = "spring", implementationName = "MapstructUserMapper")
public interface UserEntityMapper{

    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    User map(UserDto dto) ;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    UserDto mapToDto(User user);

}
