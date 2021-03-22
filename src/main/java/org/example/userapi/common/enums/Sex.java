package org.example.userapi.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Sex {
    MAN("Мужской"),
    WOMAN("Женский");

    private final String sexName;

}
