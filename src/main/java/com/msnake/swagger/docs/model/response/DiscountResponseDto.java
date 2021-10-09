package com.msnake.swagger.docs.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DiscountResponseDto {
    @ApiModelProperty(value = "Идентификатор", example = "1eece6a2-8d16-4cc4-abf6-fcaefa3d3a81")
    private UUID id;
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
    @ApiModelProperty(value = "Дата создания акции/скидки", example = "2020-01-01T12:10:15")
    private LocalDateTime createDate;
    @ApiModelProperty(value = "Дата последнего изменения акции/скидки", example = "2020-06-01T12:10:15")
    private LocalDateTime modifDate;
}
