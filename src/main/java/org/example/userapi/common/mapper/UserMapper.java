package org.example.userapi.common.mapper;

import org.example.userapi.domain.dto.UserDto;
import org.example.userapi.domain.dto.UserShortDto;
import org.example.userapi.domain.entity.User;
import org.example.userapi.domain.vm.UserVM;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        imports = {LocalDate.class})
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    @Mapping(target = "sex", source = "entity.sex.sexName")
    @Mapping(target = "birthDate", constant = "")
    UserDto toDto(User entity);

    UserShortDto toShortDto(User entity);

    @Mapping(target = "sex", constant = "WOMAN")
    @Mapping(target = "photoUrl", source = "photoUrl")
    @Mapping(target = "birthDate", expression = "java(LocalDate.of(2019,12,30))")
    User toEntity(UserVM vm, String photoUrl);
}
