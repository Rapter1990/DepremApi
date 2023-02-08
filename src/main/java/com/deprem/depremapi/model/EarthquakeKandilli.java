package com.deprem.depremapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@ApiModel(value = "Earthquake Kandilli model documentation", description = "Model")
public class EarthquakeKandilli {

    @ApiModelProperty(value = "Unique id field of EarthquakeKandilli object")
    public int id;

    @ApiModelProperty(value = "Date field of EarthquakeKandilli object")
    public String date;

    @ApiModelProperty(value = "Timestamp field of EarthquakeKandilli object")
    public int timestamp;

    @ApiModelProperty(value = "Latitude field of EarthquakeKandilli object")
    public Double latitude;

    @ApiModelProperty(value = "Longitude field of EarthquakeKandilli object")
    public Double longitude;

    @ApiModelProperty(value = "Depth field of EarthquakeKandilli object")
    public Double depth;

    @ApiModelProperty(value = "Size field of EarthquakeKandilli object")
    public Size size;

    @ApiModelProperty(value = "Location field of EarthquakeKandilli object")
    public String location;

    @ApiModelProperty(value = "Attribute field of EarthquakeKandilli object")
    public String attribute;

    @ApiModelProperty(value = "Revized date field of EarthquakeKandilli object")
    public String revizedDate;
}
