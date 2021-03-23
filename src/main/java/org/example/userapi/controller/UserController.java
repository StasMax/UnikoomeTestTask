package org.example.userapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.userapi.common.constants.Urls;
import org.example.userapi.domain.dto.UserDto;
import org.example.userapi.domain.dto.UserShortDto;
import org.example.userapi.domain.vm.UserVM;
import org.example.userapi.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "Работа с пользователями", description = "Контроллер работы с пользователями")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService service;

    @Operation(
            summary = "Добавление пользователя",
            method = "POST",
            description = "Позволяет добавить пользователя"
    )
    @PostMapping(value = Urls.User.USERS,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserDto createUser(
            @RequestParam("file") MultipartFile file,
            @RequestParam("user") String stringVm) throws JsonProcessingException {
        return service.addUser(new ObjectMapper().readValue(stringVm, UserVM.class), file);
    }

    @Operation(
            summary = "Получение списка всех пользователей",
            method = "GET",
            description = "Позволяет получить список всех пользователей"
    )
    @GetMapping(value = Urls.User.USERS)
    public List<UserShortDto> getAllUsers() {
        return service.getAllUsers();
    }

    @Operation(
            summary = "Получение данных о пользователе",
            method = "GET",
            description = "Позволяет получить данные пользователя по id"
    )
    @Parameters({
            @Parameter(
                    name = "user",
                    required = true,
                    description = "id пользователя",
                    example = "2"),
    })
    @GetMapping(value = Urls.User.Id.FULL)
    public UserDto getUser(@PathVariable("id") Long userId) {
        return service.getUser(userId);
    }
}
