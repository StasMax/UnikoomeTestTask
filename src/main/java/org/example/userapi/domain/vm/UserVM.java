package org.example.userapi.domain.vm;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserVM {

    @NotBlank(message = "Имя пользователя не может быть пустым.")
    private String userName;

    private String fio;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,6}$", message = "Введен неверный email.")
    @NotBlank(message = "email не может быть пустым")
    private String email;

    @Pattern(regexp = "(0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[012]).((19|20)\\d\\d)",
            message = "Введена некорректная дата рождения, дата должна соответствовать формату дд.мм.гггг.")
    private String birthDate;

    @Pattern(regexp = "(Мужской|Женский)",
            message = "Введен некорректный пол, пол может быть Мужской или Женский.")
    private String sex;
}
