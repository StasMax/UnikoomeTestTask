package org.example.userapi.domain.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String userName;

    private String fio;

    private String email;

    private String birthDate;

    private String sex;

    private String photoUrl;
}
