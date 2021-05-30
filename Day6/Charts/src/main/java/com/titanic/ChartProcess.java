package com.titanic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ChartProcess {
    // Read json file and return a list containing TitanicPassengerObjectspublic
    public List<TitanicPassenger> getPassengersFromJsonFile() throws IOException {
        List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger> ();
        ObjectMapper objectMapper = new ObjectMapper ();
        objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (InputStream input = new FileInputStream ("D:\\Work\\AI_ITI\\Week6_Java\\Test_Maven\\src\\main\\resources\\titanic_csv.json")) {
            //Read JSON file
            allPassengers = objectMapper.readValue (input, new TypeReference<List<TitanicPassenger>> () {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return allPassengers;
    }



    public void graphPassengerAges(List<TitanicPassenger> passengerList) {
        //filter to get an array of passenger ages
        List<Float> pAges= passengerList.stream().map (TitanicPassenger::getAge).limit (8).collect (Collectors.toList());
        List<String> pNames= passengerList.stream().map (TitanicPassenger::getName).limit (8).collect (Collectors.toList());
        //Using XCartto graph the Ages 1.Create Chart
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (768).title ("Age Histogram").xAxisTitle("Names").yAxisTitle("Age").build ();
        // 2.Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        // 3.Series
        chart.addSeries("Passenger's Ages", pNames, pAges);
        // 4.Show it
        new SwingWrapper(chart).displayChart();

    }
    public void graphPassengerClass(List<TitanicPassenger> passengerList) {

        Map<String, Long> result =passengerList.stream().collect (Collectors.groupingBy(TitanicPassenger::getPclass, Collectors.counting() ) );
        PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
        Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};chart.getStyler().setSeriesColors(sliceColors);
        chart.getStyler().setSeriesColors(sliceColors);
        chart.addSeries("First Class", result.get("1"));
        chart.addSeries("Second Class", result.get("2"));
        chart.addSeries("Third Class", result.get("3"));
        new SwingWrapper(chart).displayChart();
    }

    public void graphPassengerSurvived(List<TitanicPassenger> passengerList) {

        Map<String, Long> result =passengerList.stream().collect (Collectors.groupingBy(TitanicPassenger::getSurvived, Collectors.counting() ) );
        PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
        Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};chart.getStyler().setSeriesColors(sliceColors);
        chart.getStyler().setSeriesColors(sliceColors);
        chart.addSeries("Survived", result.get("1"));
        chart.addSeries("not Survived", result.get("0"));
        //chart.addSeries("Third Class", result.get("3"));
        new SwingWrapper(chart).displayChart();
    }

    public void graphPassengerSurvivedGendre(List<TitanicPassenger> passengerList) {

        Map<String, Long> result =passengerList.stream().filter(pass -> pass.getSurvived().equals("1")).collect (Collectors.groupingBy(TitanicPassenger::getSex, Collectors.counting() ) );
        PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
        Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};chart.getStyler().setSeriesColors(sliceColors);
        chart.getStyler().setSeriesColors(sliceColors);
        chart.addSeries("Female", result.get("female"));
        chart.addSeries("Male", result.get("male"));
        //chart.addSeries("Third Class", result.get("3"));
        new SwingWrapper(chart).displayChart();
    }



}
