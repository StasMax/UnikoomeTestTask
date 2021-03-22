package org.example.userapi.common.mapper;

import org.example.userapi.common.enums.Sex;
import org.example.userapi.domain.dto.UserDto;
import org.example.userapi.domain.dto.UserShortDto;
import org.example.userapi.domain.entity.User;
import org.example.userapi.domain.vm.UserVM;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.example.userapi.common.constants.Constant.DATE_FORMATTER_PATTERN;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

    public UserDto toDto(User entity) {
        UserDto userDto = new UserDto();
        userDto.setBirthDate(entity.getBirthDate().format(DateTimeFormatter.ofPattern(DATE_FORMATTER_PATTERN)));
        userDto.setSex(entity.getSex().getSexName());
        userDto.setEmail(entity.getEmail());
        userDto.setFio(entity.getFio());
        userDto.setUserName(entity.getUserName());
        userDto.setId(entity.getId());
        userDto.setPhotoUrl(entity.getPhotoUrl());
        return userDto;
    }

    public abstract UserShortDto toShortDto(User entity);

   public User toEntity(UserVM vm, String photoUrl) {
        User entity = new User();
        entity.setFio(vm.getFio());
        entity.setEmail(vm.getEmail());
        entity.setUserName(vm.getUserName());
        entity.setBirthDate(LocalDate.parse(vm.getBirthDate(), DateTimeFormatter.ofPattern(DATE_FORMATTER_PATTERN)));
        entity.setSex(Arrays.stream(Sex.values()).filter(item -> item.getSexName().equals(vm.getSex())).findFirst().get());
        entity.setPhotoUrl(photoUrl);
        return entity;
    }

}
