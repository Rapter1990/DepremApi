package com.deprem.depremapi.model;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EarthquakeAfad {

    public int id;
    public String date;
    public int timestamp;
    public Double latitude;
    public Double longitude;
    public Double depth;
    public Size size;
    public String location;
    public String afadId;
    public String attribute;
}
