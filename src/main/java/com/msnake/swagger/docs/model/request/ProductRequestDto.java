package com.msnake.swagger.docs.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductRequestDto {

    @ApiModelProperty(value = "Название продукта/товара", example = "IPhone10")
    private String name;
    @ApiModelProperty(value = "Название продукта/товара", example = "Крутой телефон")
    private String description;
    @ApiModelProperty(value = "Стоимость продукта/товара(в копейках)", example = "100050000")
    private Long price;
}
