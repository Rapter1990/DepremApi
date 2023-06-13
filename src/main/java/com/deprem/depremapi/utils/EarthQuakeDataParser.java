package com.deprem.depremapi.utils;

import com.deprem.depremapi.contansts.Constants;
import com.deprem.depremapi.model.EarthquakeAfad;
import com.deprem.depremapi.model.EarthquakeKandilli;
import com.deprem.depremapi.model.Size;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Log4j2
public class EarthQuakeDataParser {


    public List<EarthquakeKandilli> getEarthQuakeDataFromKandilli() throws IOException, ParseException {

        log.info("EarthQuakeDataParser | getEarthQuakeDataFromKandilli is working");

        List<EarthquakeKandilli> earthquakeList = new ArrayList<>();

        Document doc = Jsoup.connect(Constants.KANDILLI_LINK).get();
        Elements data = doc.select("pre");

        String[] dataArray = data.text().strip().split("--------------")[2].split("\n");

        String[] modifiedArray = Arrays.copyOfRange(dataArray, 1, dataArray.length);

        for (int i = 1; i < modifiedArray.length - 2; i++) {
            String element = modifiedArray[i].strip();

            element = element.replace("\s\s\s", " ");
            element = element.replace("\s\s\s\s", " ");
            element = element.replace("\s\s\s", " ");

            String[] args = element.split(" ");

            String location = args[12] + " " + args[13];

            String attribute = "";
            if(args[args.length -1].trim().equals("İlksel")){
                attribute = args[args.length -1].trim();
            }else{
                attribute = args[args.length -3];
            }

            EarthquakeKandilli earthquake = EarthquakeKandilli.builder()
                    .id(i)
                    .date(args[0] + " " + args[1])
                    .timestamp((int) (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(args[0] + " " + args[1]).getTime() / 1000))
                    .latitude(Double.parseDouble(args[3]))
                    .longitude(Double.parseDouble(args[4]))
                    .depth(args[5] != "" ? Double.parseDouble(args[5]) : Double.parseDouble(args[6]))
                    .size(Size.builder()
                            .md(args[7] != "" ? Double.parseDouble(args[7].replace("-.-", "0")) : Double.parseDouble(args[8].replace("-.-", "0")))
                            .ml(args[9] != "" ? Double.parseDouble(args[9].replace("-.-", "0")) : Double.parseDouble(args[10].replace("-.-", "0")))
                            .mw(args[11] != "" ? Double.parseDouble(args[11].replace("-.-", "0")) : Double.parseDouble(args[12].replace("-.-", "0")))
                            .build())
                    .location(location)
                    .attribute(attribute)
                    .revizedDate(attribute.equals("REVIZE01") ? (args[args.length -2] + " " + args[args.length -1]).replaceAll("[()]","") : "")
                    .build();

            earthquakeList.add(earthquake);
        }

        return earthquakeList;
    }

    public List<EarthquakeAfad> getEarthQuakeDataFromAfad() throws IOException, ParseException {

        log.info("EarthQuakeDataParser | getEarthQuakeDataFromAfad is working");

        List<EarthquakeAfad> earthquakeList = new ArrayList<>();

        Document doc = Jsoup.connect(Constants.AFAD_LINK).get();
        Elements trs = doc.select("tr");

        trs.remove(0);

        log.info("EarthQuakeDataParser | getEarthQuakeDataFromAfad | trs size : " + trs.size());

        for (int i = 0; i < trs.size(); i++) {

            Element tr = trs.get(i);
            Elements tds = tr.select("td");

            String earthquakeType = tds.get(4).text();

            EarthquakeAfad earthquake = EarthquakeAfad.builder()
                    .id((i+1))
                    .date(tds.get(0).text())
                    .timestamp((int) LocalDateTime.parse(tds.get(0).text(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                            .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())
                    .latitude(Double.parseDouble(tds.get(1).text()))
                    .longitude(Double.parseDouble(tds.get(2).text()))
                    .depth(Double.parseDouble(tds.get(3).text()))
                    .size(Size.builder()
                            .md(earthquakeType.equals("MD") ? Double.parseDouble(tds.get(5).text()) : 0)
                            .ml(earthquakeType.equals("ML") ? Double.parseDouble(tds.get(5).text()) : 0)
                            .mw(earthquakeType.equals("MW") ? Double.parseDouble(tds.get(5).text()) : 0)
                            .build())
                    .location(tds.get(6).text())
                    .afadId(tds.get(7).text())
                    .attribute(earthquakeType)
                    .build();

            earthquakeList.add(earthquake);
        }

        return earthquakeList;
    }
}
