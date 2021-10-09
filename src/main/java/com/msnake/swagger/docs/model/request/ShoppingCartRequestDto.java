package com.msnake.swagger.docs.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class ShoppingCartRequestDto {

    @ApiModelProperty(value = "Идентификатор продукта/товара", example = "1eece6a2-8d16-4cc4-abf6-fcaefa3d3a81")
    private UUID productId;
    @ApiModelProperty(value = "Количество товаров к покупке", example = "1")
    private Long count;
    @ApiModelProperty(value = "Идентификатор корзины", example = "1eece6a2-8d16-4cc4-abf6-fcaefa3d3a81")
    private UUID basketId;
}
