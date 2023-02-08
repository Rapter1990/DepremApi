package com.deprem.depremapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Size model documentation", description = "Model")
public class Size {

    @ApiModelProperty(value = "md field of Size object")
    public Double md;

    @ApiModelProperty(value = "ml field of Size object")
    public Double ml;

    @ApiModelProperty(value = "mw field of Size object")
    public Double mw;
}
