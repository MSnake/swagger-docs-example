package com.msnake.swagger.docs.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class BasketRequestDto {

    @ApiModelProperty(value = "Идентификатор сессии", example = "123456")
    private String session;
    @ApiModelProperty(value = "Сумма к оплате(в копейках)", example = "35600")
    private Long totalPrice;
    @ApiModelProperty(value = "Идентификатор пользователя", example = "1eece6a2-8d16-4cc4-abf6-fcaefa3d3a81")
    private UUID userId;
    @ApiModelProperty(value = "Признак оплачена ли корзина покупок", example = "true")
    private Boolean paid;
}
