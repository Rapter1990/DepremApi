package com.deprem.depremapi.service;

import com.deprem.depremapi.model.EarthquakeAfad;
import com.deprem.depremapi.model.EarthquakeKandilli;
import com.deprem.depremapi.utils.EarthQuakeDataParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class EarthQuakeService {

    private final EarthQuakeDataParser earthQuakeDataParser;

    public List<EarthquakeKandilli> getEarthquakesFromKandilli() throws IOException, ParseException {

        log.info("EarthQuakeService | getEarthquakesFromKandilli is working");
        return earthQuakeDataParser.getEarthQuakeDataFromKandilli();
    }

    public List<EarthquakeAfad> getEarthQuakeDataFromAfad() throws IOException, ParseException{

        log.info("EarthQuakeService | getEarthQuakeDataFromAfad is working");
        return earthQuakeDataParser.getEarthQuakeDataFromAfad();
    }

    public List<EarthquakeKandilli> filterByLocationForKandilli(String location, List<EarthquakeKandilli> data) {

        log.info("EarthQuakeService | filterByLocationForKandilli is working");

        return data.stream()
                .filter(i -> i.location.toUpperCase().contains(location.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<EarthquakeAfad> filterByLocationForAfad(String location, List<EarthquakeAfad> data) {

        log.info("EarthQuakeService | filterByLocationForAfad is working");

        return data.stream()
                .filter(i -> i.location.toUpperCase().contains(location.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<EarthquakeKandilli> filterBySizeMLForKandilli(String size, List<EarthquakeKandilli> data) {

        log.info("EarthQuakeService | filterBySizeMLForKandilli is working");

        return data.stream()
                .filter(i -> Double.parseDouble(size) >= (double) i.size.ml)
                .collect(Collectors.toList());
    }

    public List<EarthquakeAfad> filterBySizeMLForAfad(String size, List<EarthquakeAfad> data) {

        log.info("EarthQuakeService | filterBySizeMLForAfad is working");

        return data.stream()
                .filter(i -> Double.parseDouble(size) >= i.size.ml)
                .collect(Collectors.toList());
    }

    public List<EarthquakeKandilli> filterByLocationAndSizeForKandilli(String size, String location, List<EarthquakeKandilli> data) {

        log.info("EarthQuakeService | filterByLocationAndSizeForKandilli is working");

        return data.stream()
                .filter(i -> Double.parseDouble(size) >= i.size.ml
                        && (i.location.toUpperCase().contains(location.toUpperCase())))
                .collect(Collectors.toList());
    }

    public List<EarthquakeAfad> filterByLocationAndSizeForAfad(String size, String location, List<EarthquakeAfad> data) {

        log.info("EarthQuakeService | filterByLocationAndSizeForAfad is working");

        return data.stream()
                .filter(i -> Double.parseDouble(size) >= i.size.ml
                        && (i.location.toUpperCase().contains(location.toUpperCase())))
                .collect(Collectors.toList());

    }

    public List<EarthquakeKandilli> filterBySizeBetweenTwoMLForKandili(String sizeFirst, String sizeSecond, List<EarthquakeKandilli> data) {

        log.info("EarthQuakeService | filterBySizeBetweenTwoMLForKandili is working");

        return data.stream()
                .filter(i -> Double.parseDouble(sizeFirst) <= i.size.ml && Double.parseDouble(sizeSecond) >= i.size.ml)
                .collect(Collectors.toList());

    }

    public List<EarthquakeAfad> filterBySizeBetweenTwoMLForAfad(String sizeFirst, String sizeSecond, List<EarthquakeAfad> data) {

        log.info("EarthQuakeService | filterBySizeBetweenTwoMLForAfad is working");

        return data.stream()
                .filter(i -> Double.parseDouble(sizeFirst) <= i.size.ml && Double.parseDouble(sizeSecond) >= i.size.ml)
                .collect(Collectors.toList());

    }

}
