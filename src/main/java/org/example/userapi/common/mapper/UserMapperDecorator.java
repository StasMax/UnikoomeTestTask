package org.example.userapi.common.mapper;

import org.example.userapi.common.enums.Sex;
import org.example.userapi.domain.dto.UserDto;
import org.example.userapi.domain.entity.User;
import org.example.userapi.domain.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.example.userapi.common.constants.Constant.DATE_FORMATTER_PATTERN;

public abstract class UserMapperDecorator implements UserMapper {

    @Autowired
    private UserMapper delegate;

    @Override
    public UserDto toDto(User entity) {
        UserDto userDto = delegate.toDto(entity);
        userDto.setBirthDate(entity.getBirthDate().format(DateTimeFormatter.ofPattern(DATE_FORMATTER_PATTERN)));
        return userDto;
    }

    @Override
    public User toEntity(UserVM vm, String photoUrl) {
        User entity = delegate.toEntity(vm, photoUrl);
        entity.setBirthDate(LocalDate.parse(vm.getBirthDate(), DateTimeFormatter.ofPattern(DATE_FORMATTER_PATTERN)));
        entity.setSex(Arrays.stream(Sex.values()).filter(item -> item.getSexName().equals(vm.getSex())).findFirst().get());
        return entity;
    }
}
