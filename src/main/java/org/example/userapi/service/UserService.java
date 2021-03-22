package org.example.userapi.service;

import org.example.userapi.domain.dto.UserDto;
import org.example.userapi.domain.dto.UserShortDto;
import org.example.userapi.domain.vm.UserVM;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    UserDto addUser(UserVM vm, MultipartFile multipartFile);

    List<UserShortDto> getAllUsers();

    UserDto getUser(Long id);
}
