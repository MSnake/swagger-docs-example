package com.msnake.swagger.docs.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class IdResponseDto {
    @ApiModelProperty(value = "Идентификатор", example = "1eece6a2-8d16-4cc4-abf6-fcaefa3d3a81")
    private UUID id;
}
