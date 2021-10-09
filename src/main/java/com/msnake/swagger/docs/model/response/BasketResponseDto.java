package com.msnake.swagger.docs.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BasketResponseDto {
    @ApiModelProperty(value = "Идентификатор", example = "1eece6a2-8d16-4cc4-abf6-fcaefa3d3a81")
    private UUID id;
    @ApiModelProperty(value = "Идентификатор сессии", example = "123456")
    private String session;
    @ApiModelProperty(value = "Сумма к оплате(в копейках)", example = "35600")
    private Long totalPrice;
    @ApiModelProperty(value = "Идентификатор корзины", example = "1eece6a2-8d16-4cc4-abf6-fcaefa3d3a81")
    private UUID userId;
    @ApiModelProperty(value = "Идентификатор пользователя", example = "1eece6a2-8d16-4cc4-abf6-fcaefa3d3a81")
    private Boolean paid;
    @ApiModelProperty(value = "Дата создания корзины", example = "2020-01-01T12:10:15")
    private LocalDateTime createDate;
}
