package com.msnake.swagger.docs.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiscountRequestDto {

    @ApiModelProperty(value = "Название акции/скидки", example = "autumn sale")
    private String name;
    @ApiModelProperty(value = "Описание акции/скидки", example = "Осенняя распродажа")
    private String description;
    @ApiModelProperty(value = "Является ли акция/скидка активной", example = "true")
    private Boolean active;
    @ApiModelProperty(value = "Количественный показатель скидки в процентах(от 0 до 100)", example = "25")
    private Long value;
    @ApiModelProperty(value = "Дата начала действия акции/скидки", example = "2020-06-01")
    private LocalDateTime startDate;
    @ApiModelProperty(value = "Дата окончания действия акции/скидки", example = "2020-07-01")
    private LocalDateTime finishDate;
}
