package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class FilterFactory {
    private final List<Filter> filters;
    private List<Flight> flights;

    public FilterFactory(List<Flight> flights) {
        this.flights = flights;
        filters = new ArrayList<>(asList(
                new DepartureBeforeNow(),
                new ArrivalDateBeforeDepartureDate(),
                new TotalTimeSpentOnTheGroundExceedsTwoHours()));
    }

    public void start() {
        System.out.println("Фильтрация перелетов включена: ");

        for (Filter filterFactory : filters) {
            flights = filterFactory.filter(flights);
        }
        System.out.println("Набор перелетов после фильтрации: ");
        System.out.println(flights);
    }
}
