package com.deprem.depremapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Earthquake Afad model documentation", description = "Model")
public class EarthquakeAfad {

    @ApiModelProperty(value = "Unique id field of EarthquakeAfad object")
    public int id;

    @ApiModelProperty(value = "Date field of EarthquakeAfad object")
    public String date;

    @ApiModelProperty(value = "Timestamp field of EarthquakeAfad object")
    public int timestamp;

    @ApiModelProperty(value = "Latitude field of EarthquakeAfad object")
    public Double latitude;

    @ApiModelProperty(value = "Longitude field of EarthquakeAfad object")
    public Double longitude;

    @ApiModelProperty(value = "Depth field of EarthquakeAfad object")
    public Double depth;

    @ApiModelProperty(value = "Size field of EarthquakeAfad object")
    public Size size;

    @ApiModelProperty(value = "Location field of EarthquakeAfad object")
    public String location;

    @ApiModelProperty(value = "Afad id field of EarthquakeAfad object")
    public String afadId;

    @ApiModelProperty(value = "Attribute field of EarthquakeAfad object")
    public String attribute;
}
