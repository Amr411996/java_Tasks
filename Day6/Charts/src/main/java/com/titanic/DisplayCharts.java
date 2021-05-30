package com.titanic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DisplayCharts {
    public static void main(String[] args) throws IOException {

        ChartProcess passenger = new ChartProcess();
        List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger>();
        allPassengers = passenger.getPassengersFromJsonFile();
       passenger.graphPassengerAges(allPassengers);
        passenger.graphPassengerClass(allPassengers);
        passenger.graphPassengerSurvived(allPassengers);
        passenger.graphPassengerSurvivedGendre(allPassengers);
    }
}
