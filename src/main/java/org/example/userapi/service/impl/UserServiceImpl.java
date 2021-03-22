package org.example.userapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.userapi.common.exception.ServiceException;
import org.example.userapi.common.mapper.UserMapper;
import org.example.userapi.common.helper.ObjectValidator;
import org.example.userapi.domain.dto.UserDto;
import org.example.userapi.domain.dto.UserShortDto;
import org.example.userapi.domain.vm.UserVM;
import org.example.userapi.repository.UserRepository;
import org.example.userapi.service.StorageService;
import org.example.userapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final StorageService storageService;
    private final UserMapper mapper;
    private final ObjectValidator objectValidator;

    @Transactional
    @Override
    public UserDto addUser(UserVM vm, MultipartFile multipartFile) {

        objectValidator.validateObject(vm);

        String photoUrl = null;

        if (repository.existsByUserName(vm.getUserName())) {
            throw new ServiceException("Пользователь с таким именем уже существует");
        }

        if (!multipartFile.isEmpty()) {
            try (InputStream inputStream = multipartFile.getInputStream()) {
                photoUrl = storageService.uploadFile(inputStream, UUID.randomUUID().toString());
            } catch (IOException e) {
                throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR, e);
            }
        }

        return mapper.toDto(repository.save(mapper.toEntity(vm, photoUrl)));
    }

    @Transactional
    @Override
    public List<UserShortDto> getAllUsers() {
        return repository.findAll().stream().map(mapper::toShortDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public UserDto getUser(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new ServiceException("Пользователь с id: " + id + " не найден")));
    }
}
