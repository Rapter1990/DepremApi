package com.deprem.depremapi.service;

import com.deprem.depremapi.model.EarthquakeAfad;
import com.deprem.depremapi.model.EarthquakeKandilli;
import com.deprem.depremapi.model.Size;
import com.deprem.depremapi.utils.EarthQuakeDataParser;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EarthQuakeServiceTest extends BaseServiceTest{

    @InjectMocks
    private EarthQuakeService earthQuakeService;

    @Mock
    private EarthQuakeDataParser earthQuakeDataParser;

    @Test
    void getEarthquakesFromKandilli() throws IOException, ParseException {
        List<EarthquakeKandilli> expected = new ArrayList<>();

        EarthquakeKandilli earthQuake1ForKandilli = EarthquakeKandilli.builder().build();
        EarthquakeKandilli earthQuake2ForKandilli = EarthquakeKandilli.builder().build();

        expected = List.of(earthQuake1ForKandilli,earthQuake2ForKandilli);

        when(earthQuakeDataParser.getEarthQuakeDataFromKandilli()).thenReturn(expected);

        List<EarthquakeKandilli> result = earthQuakeService.getEarthquakesFromKandilli();

        assertEquals(expected, result);
        assertEquals(expected.size(), result.size());
    }

    @Test
    void getEarthQuakeDataFromAfad() throws IOException, ParseException {
        List<EarthquakeAfad> expected = new ArrayList<>();

        EarthquakeAfad earthQuake1ForAfad = EarthquakeAfad.builder().build();
        EarthquakeAfad earthQuake2ForAfad = EarthquakeAfad.builder().build();

        expected = List.of(earthQuake1ForAfad,earthQuake2ForAfad);

        when(earthQuakeDataParser.getEarthQuakeDataFromAfad()).thenReturn(expected);

        List<EarthquakeAfad> result = earthQuakeService.getEarthQuakeDataFromAfad();

        System.out.println(expected.size());
        System.out.println(result.size());
        assertEquals(expected, result);
        assertEquals(expected.size(), result.size());
    }

    @Test
    void filterByLocationForKandilli() throws IOException, ParseException {

        List<EarthquakeKandilli> expected = new ArrayList<>();

        EarthquakeKandilli earthQuake1ForKandilli = EarthquakeKandilli.builder()
                .location("Istanbul")
                .build();

        EarthquakeKandilli earthQuake2ForKandilli = EarthquakeKandilli.builder()
                .location("Ankara")
                .build();

        EarthquakeKandilli earthQuake3ForKandilli = EarthquakeKandilli.builder()
                .location("Izmir")
                .build();

        expected = List.of(earthQuake1ForKandilli,earthQuake2ForKandilli,earthQuake3ForKandilli);

        String location = "I";

        List<EarthquakeKandilli> result = earthQuakeService.filterByLocationForKandilli(location,expected);

        assertEquals(2, result.size());
        assertEquals("Istanbul", result.get(0).location);
        assertEquals("Izmir", result.get(1).location);

    }

    @Test
    void filterByLocationForAfad() {

        List<EarthquakeAfad> expected = new ArrayList<>();

        EarthquakeAfad earthQuake1ForAfad = EarthquakeAfad.builder()
                .location("Istanbul")
                .build();

        EarthquakeAfad earthQuake2ForAfad = EarthquakeAfad.builder()
                .location("Ankara")
                .build();

        EarthquakeAfad earthQuake3ForAfad = EarthquakeAfad.builder()
                .location("Izmir")
                .build();

        expected = List.of(earthQuake1ForAfad,earthQuake2ForAfad,earthQuake3ForAfad);

        String location = "I";

        List<EarthquakeAfad> result = earthQuakeService.filterByLocationForAfad(location,expected);

        assertEquals(2, result.size());
        assertEquals("Istanbul", result.get(0).location);
        assertEquals("Izmir", result.get(1).location);

    }

    @Test
    void filterBySizeMLForKandilli() {

        List<EarthquakeKandilli> expected = new ArrayList<>();

        EarthquakeKandilli earthQuake1ForKandilli = EarthquakeKandilli.builder()
                .location("Istanbul")
                .size(Size.builder()
                        .ml(3.1)
                        .build())
                .build();

        EarthquakeKandilli earthQuake2ForKandilli = EarthquakeKandilli.builder()
                .location("Ankara")
                .size(Size.builder()
                        .ml(2.9)
                        .build())
                .build();

        EarthquakeKandilli earthQuake3ForKandilli = EarthquakeKandilli.builder()
                .location("Izmir")
                .size(Size.builder()
                        .ml(3.3)
                        .build())
                .build();

        expected = List.of(earthQuake1ForKandilli,earthQuake2ForKandilli,earthQuake3ForKandilli);

        String size = "3.0";

        List<EarthquakeKandilli> result = earthQuakeService.filterBySizeMLForKandilli(size,expected);

        assertEquals(1, result.size());
        assertEquals("Ankara", result.get(0).location);

    }

    @Test
    void filterBySizeMLForAfad() {

        List<EarthquakeAfad> expected = new ArrayList<>();

        EarthquakeAfad earthQuake1ForAfad = EarthquakeAfad.builder()
                .location("Istanbul")
                .size(Size.builder()
                        .ml(3.1)
                        .build())
                .build();

        EarthquakeAfad earthQuake2ForAfad = EarthquakeAfad.builder()
                .location("Ankara")
                .size(Size.builder()
                        .ml(2.9)
                        .build())
                .build();

        EarthquakeAfad earthQuake3ForAfad = EarthquakeAfad.builder()
                .location("Izmir")
                .size(Size.builder()
                        .ml(3.3)
                        .build())
                .build();

        expected = List.of(earthQuake1ForAfad,earthQuake2ForAfad,earthQuake3ForAfad);

        String size = "3.0";

        List<EarthquakeAfad> result = earthQuakeService.filterBySizeMLForAfad(size,expected);

        assertEquals(1, result.size());
        assertEquals("Ankara", result.get(0).location);

    }

    @Test
    void filterByLocationAndSizeForKandilli() {

        List<EarthquakeKandilli> expected = new ArrayList<>();

        EarthquakeKandilli earthQuake1ForKandilli = EarthquakeKandilli.builder()
                .location("Istanbul")
                .size(Size.builder()
                        .ml(3.1)
                        .build())
                .build();

        EarthquakeKandilli earthQuake2ForKandilli = EarthquakeKandilli.builder()
                .location("Ankara")
                .size(Size.builder()
                        .ml(2.9)
                        .build())
                .build();

        EarthquakeKandilli earthQuake3ForKandilli = EarthquakeKandilli.builder()
                .location("Izmir")
                .size(Size.builder()
                        .ml(3.3)
                        .build())
                .build();

        EarthquakeKandilli earthQuake4ForKandilli = EarthquakeKandilli.builder()
                .location("Istanbul")
                .size(Size.builder()
                        .ml(3.4)
                        .build())
                .build();

        expected = List.of(earthQuake1ForKandilli,earthQuake2ForKandilli,earthQuake3ForKandilli,earthQuake4ForKandilli);

        String size = "3.5";
        String location = "Istanbul";

        List<EarthquakeKandilli> result = earthQuakeService.filterByLocationAndSizeForKandilli(size,location,expected);

        assertEquals(2, result.size());
        assertEquals("Istanbul", result.get(0).location);
        assertEquals("Istanbul", result.get(1).location);

    }

    @Test
    void filterByLocationAndSizeForAfad() {

        List<EarthquakeAfad> expected = new ArrayList<>();

        EarthquakeAfad earthQuake1ForAfad = EarthquakeAfad.builder()
                .location("Istanbul")
                .size(Size.builder()
                        .ml(3.1)
                        .build())
                .build();

        EarthquakeAfad earthQuake2ForAfad = EarthquakeAfad.builder()
                .location("Ankara")
                .size(Size.builder()
                        .ml(2.9)
                        .build())
                .build();

        EarthquakeAfad earthQuake3ForAfad = EarthquakeAfad.builder()
                .location("Izmir")
                .size(Size.builder()
                        .ml(3.3)
                        .build())
                .build();

        EarthquakeAfad earthQuake4ForAfad = EarthquakeAfad.builder()
                .location("Istanbul")
                .size(Size.builder()
                        .ml(3.4)
                        .build())
                .build();

        expected = List.of(earthQuake1ForAfad,earthQuake2ForAfad,earthQuake3ForAfad,earthQuake4ForAfad);

        String size = "3.5";
        String location = "Istanbul";

        List<EarthquakeAfad> result = earthQuakeService.filterByLocationAndSizeForAfad(size,location,expected);

        assertEquals(2, result.size());
        assertEquals("Istanbul", result.get(0).location);
        assertEquals("Istanbul", result.get(1).location);


    }

    @Test
    void filterBySizeBetweenTwoMLForKandili() {

        List<EarthquakeKandilli> expected = new ArrayList<>();

        EarthquakeKandilli earthQuake1ForKandilli = EarthquakeKandilli.builder()
                .location("Istanbul")
                .size(Size.builder()
                        .ml(3.1)
                        .build())
                .build();

        EarthquakeKandilli earthQuake2ForKandilli = EarthquakeKandilli.builder()
                .location("Ankara")
                .size(Size.builder()
                        .ml(2.9)
                        .build())
                .build();

        EarthquakeKandilli earthQuake3ForKandilli = EarthquakeKandilli.builder()
                .location("Izmir")
                .size(Size.builder()
                        .ml(3.3)
                        .build())
                .build();

        EarthquakeKandilli earthQuake4ForKandilli = EarthquakeKandilli.builder()
                .location("Istanbul")
                .size(Size.builder()
                        .ml(3.4)
                        .build())
                .build();

        expected = List.of(earthQuake1ForKandilli,earthQuake2ForKandilli,earthQuake3ForKandilli,earthQuake4ForKandilli);

        String sizeFirst = "3.1";
        String sizeSecond = "3.5";

        List<EarthquakeKandilli> result = earthQuakeService.filterBySizeBetweenTwoMLForKandili(sizeFirst,sizeSecond,expected);

        assertEquals(3, result.size());
        assertEquals("Istanbul", result.get(0).location);
        assertEquals("Izmir", result.get(1).location);
        assertEquals("Istanbul", result.get(2).location);

    }

    @Test
    void filterBySizeBetweenTwoMLForAfad() {

        List<EarthquakeAfad> expected = new ArrayList<>();

        EarthquakeAfad earthQuake1ForKandilli = EarthquakeAfad.builder()
                .location("Istanbul")
                .size(Size.builder()
                        .ml(3.1)
                        .build())
                .build();

        EarthquakeAfad earthQuake2ForKandilli = EarthquakeAfad.builder()
                .location("Ankara")
                .size(Size.builder()
                        .ml(2.9)
                        .build())
                .build();

        EarthquakeAfad earthQuake3ForKandilli = EarthquakeAfad.builder()
                .location("Izmir")
                .size(Size.builder()
                        .ml(3.3)
                        .build())
                .build();

        EarthquakeAfad earthQuake4ForKandilli = EarthquakeAfad.builder()
                .location("Istanbul")
                .size(Size.builder()
                        .ml(3.4)
                        .build())
                .build();

        expected = List.of(earthQuake1ForKandilli,earthQuake2ForKandilli,earthQuake3ForKandilli,earthQuake4ForKandilli);

        String sizeFirst = "3.1";
        String sizeSecond = "3.5";

        List<EarthquakeAfad> result = earthQuakeService.filterBySizeBetweenTwoMLForAfad(sizeFirst,sizeSecond,expected);

        assertEquals(3, result.size());
        assertEquals("Istanbul", result.get(0).location);
        assertEquals("Izmir", result.get(1).location);
        assertEquals("Istanbul", result.get(2).location);
    }
}