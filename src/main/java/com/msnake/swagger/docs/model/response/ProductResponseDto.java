package com.msnake.swagger.docs.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductResponseDto {
    @ApiModelProperty(value = "Идентификатор", example = "1eece6a2-8d16-4cc4-abf6-fcaefa3d3a81")
    private UUID id;
    @ApiModelProperty(value = "Название продукта/товара", example = "IPhone10")
    private String name;
    @ApiModelProperty(value = "Название продукта/товара", example = "Крутой телефон")
    private String description;
    @ApiModelProperty(value = "Стоимость продукта/товара(в копейках)", example = "100050000")
    private Long price;
    @ApiModelProperty(value = "Дата создания продукта/товара", example = "2020-01-01T12:10:15")
    private LocalDateTime createDate;
    @ApiModelProperty(value = "Дата последнего изменения продукта/товара", example = "2020-06-01T12:10:15")
    private LocalDateTime modifDate;
}
