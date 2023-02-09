package com.deprem.depremapi.api;

import com.deprem.depremapi.model.EarthquakeAfad;
import com.deprem.depremapi.model.EarthquakeKandilli;
import com.deprem.depremapi.service.EarthQuakeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/earthquakes")
@RequiredArgsConstructor
@Log4j2
@Tag(description = "Earthquake APIs for Kandilli and Afad",
        name = "Earthquake Controller")
public class EarthquakeController {

    private final EarthQuakeService earthQuakesService;

    @Operation(description = "Get All Earthquakes From Kandilli")
    @GetMapping("/kandili")
    public List<EarthquakeKandilli> getAllEarthquakesForKandilli() throws IOException, ParseException {

        log.info("EarthquakeController | getEarthquakesFromKandilli is working");
        return earthQuakesService.getEarthquakesFromKandilli();
    }

    @Operation(description = "Get All Earthquakes From Afad")
    @GetMapping("/afad")
    public List<EarthquakeAfad>  getAllEarthquakesForAfad() throws IOException, ParseException {

        log.info("EarthquakeController | getAllEarthquakesForAfad is working");
        return earthQuakesService.getEarthQuakeDataFromAfad();
    }

    @Operation(description = "Filter By Location From Kandilli Earthquakes")
    @GetMapping("/kandili/locations/{location}")
    public List<EarthquakeKandilli> filterByLocationForKandilli(@PathVariable String location) throws IOException, ParseException {

        log.info("EarthquakeController | filterByLocationForKandilli is working");
        return earthQuakesService.filterByLocationForKandilli(location,earthQuakesService.getEarthquakesFromKandilli());
    }

    @Operation(description = "Filter By Location From Afad Earthquakes")
    @GetMapping("/afad/locations/{location}")
    public List<EarthquakeAfad> filterByLocationForAfad(@PathVariable String location) throws IOException, ParseException {

        log.info("EarthquakeController | filterByLocationForAfad is working");
        return earthQuakesService.filterByLocationForAfad(location,earthQuakesService.getEarthQuakeDataFromAfad());
    }

    @Operation(description = "Filter By Size ML From Kandilli Earthquakes")
    @GetMapping("/kandili/sizes/{size}")
    public List<EarthquakeKandilli> filterBySizeMLForKandilli(@PathVariable String size) throws IOException, ParseException {

        log.info("EarthquakeController | filterBySizeMLForKandilli is working");
        return earthQuakesService.filterBySizeMLForKandilli(size,earthQuakesService.getEarthquakesFromKandilli());
    }

    @Operation(description = "Filter By Size ML From Afad Earthquakes")
    @GetMapping("/afad/sizes/{size}")
    public List<EarthquakeAfad> filterBySizeMLForAfad(@PathVariable String size) throws IOException, ParseException{

        log.info("EarthquakeController | filterBySizeMLForAfad is working");
        return earthQuakesService.filterBySizeMLForAfad(size,earthQuakesService.getEarthQuakeDataFromAfad());
    }

    @Operation(description = "Filter By Location and Size ML From Kandilli Earthquakes")
    @GetMapping("/kandili/search")
    public List<EarthquakeKandilli> filterByLocationAndSizeForKandilli(@RequestParam("location") String location,
                                                                       @RequestParam("size") String size) throws IOException, ParseException{

        log.info("EarthquakeController | filterByLocationAndSizeForKandilli is working");
        log.info("EarthquakeController | filterByLocationAndSizeForKandilli | location " + location);
        log.info("EarthquakeController | filterByLocationAndSizeForKandilli | size " + size);
        return earthQuakesService.filterByLocationAndSizeForKandilli(size,location,earthQuakesService.getEarthquakesFromKandilli());
    }

    @Operation(description = "Filter By Location and Size ML From Afad Earthquakes")
    @GetMapping("/afad/search")
    public List<EarthquakeAfad> filterByLocationAndSizeForAfad(@RequestParam("location") String location,
                                                                   @RequestParam("size") String size
                                                                   ) throws IOException, ParseException{

        log.info("EarthquakeController | filterByLocationAndSizeForAfad is working");
        log.info("EarthquakeController | filterByLocationAndSizeForAfad | location " + location);
        log.info("EarthquakeController | filterByLocationAndSizeForAfad | size " + size);
        return earthQuakesService.filterByLocationAndSizeForAfad(size,location,earthQuakesService.getEarthQuakeDataFromAfad());
    }

    @Operation(description = "Filter By Size Between Two ML's From Kandili Earthquakes")
    @GetMapping("/kandili/sizes")
    public List<EarthquakeKandilli> filterBySizeBetweenTwoMLForKandili(@RequestParam("minml") String minml,
                                                                       @RequestParam("maxml") String maxml) throws IOException, ParseException{

        log.info("EarthquakeController | filterBySizeBetweenTwoMLForKandili is working");
        log.info("EarthquakeController | filterBySizeBetweenTwoMLForKandili | minml " + minml);
        log.info("EarthquakeController | filterBySizeBetweenTwoMLForKandili | minml " + minml);
        return earthQuakesService.filterBySizeBetweenTwoMLForKandili(minml,maxml,earthQuakesService.getEarthquakesFromKandilli());
    }

    @Operation(description = "Filter By Size Between Two ML's From Afad Earthquakes")
    @GetMapping("/afad/sizes")
    public List<EarthquakeAfad> filterBySizeBetweenTwoMLForAfad(@RequestParam("minml") String minml,
                                                                @RequestParam("maxml") String maxml) throws IOException, ParseException{

        log.info("EarthquakeController | filterBySizeBetweenTwoMLForAfad is working");
        log.info("EarthquakeController | filterBySizeBetweenTwoMLForAfad | minml " + minml);
        log.info("EarthquakeController | filterBySizeBetweenTwoMLForAfad | minml " + minml);
        return earthQuakesService.filterBySizeBetweenTwoMLForAfad(minml,maxml,earthQuakesService.getEarthQuakeDataFromAfad());
    }

}
