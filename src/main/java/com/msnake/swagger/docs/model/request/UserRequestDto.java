package com.msnake.swagger.docs.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequestDto {
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
}
