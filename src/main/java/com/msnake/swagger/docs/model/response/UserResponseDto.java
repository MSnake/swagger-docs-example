package com.msnake.swagger.docs.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserResponseDto {
    @ApiModelProperty(value = "Идентификатор", example = "1eece6a2-8d16-4cc4-abf6-fcaefa3d3a81")
    private UUID id;
    @ApiModelProperty(value = "Логин пользователя", example = "nagibator3000")
    private String login;
    @ApiModelProperty(value = "Пароль пользователя", example = "bestPassword4ever")
    private String password;
    @ApiModelProperty(value = "ФИО пользователя", example = "Иванов Иван Иванович")
    private String fio;
    @ApiModelProperty(value = "Телефон пользователя", example = "+754684135897135")
    private String phone;
    @ApiModelProperty(value = "Дата рождения", example = "01.01.2000")
    private LocalDate birthdate;
    @ApiModelProperty(value = "Дата создания пользователя", example = "2020-01-01T12:10:15")
    private LocalDateTime createDate;
    @ApiModelProperty(value = "Дата последнего изменения пользователя", example = "2020-06-01T12:10:15")
    private LocalDateTime modifDate;
}
