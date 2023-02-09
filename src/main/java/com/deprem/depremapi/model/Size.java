package com.deprem.depremapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Size {

    public Double md;
    public Double ml;
    public Double mw;
}
