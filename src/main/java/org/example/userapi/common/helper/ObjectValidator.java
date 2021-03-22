package org.example.userapi.common.helper;

import lombok.extern.slf4j.Slf4j;
import org.example.userapi.common.exception.ServiceException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
@Slf4j
public class ObjectValidator {

    private Validator validator;

    /**
     * Инициализирует объект Validator для валидации полей объекта.
     */
    @PostConstruct
    private void initValidatorFactory() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    /**
     * Валидирует поля аннотированные аннотациями из пакета javax.validation.constraints
     *
     * @param model Объект для проверки
     * @param <T>
     */
    public <T> void validateObject(T model) {
        Set<ConstraintViolation<T>> validates = validator.validate(model);
        if (validates.size() > 0) {
            StringBuilder sb = new StringBuilder();
            validates.forEach(item -> sb.append(item.getMessage()).append(" "));
            throw new ServiceException(sb.toString().trim());
        }
    }
}

