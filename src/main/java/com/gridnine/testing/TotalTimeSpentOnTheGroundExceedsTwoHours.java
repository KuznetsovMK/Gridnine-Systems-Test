package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 3. - Общее время, проведённое на земле превышает два часа
 * (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
 */

public class TotalTimeSpentOnTheGroundExceedsTwoHours implements Filter {

    private LocalDateTime localDateTimeDeparture;
    private LocalDateTime localDateTimeArrival;

    @Override
    public List<Flight> filter(List<Flight> flightList) {

        System.out.println("3. Исключены перелеты, где общее время, проведённое на земле превышает 2 часа");

        List<Flight> newFlightList = new ArrayList<>(flightList);

        int cnt = 0;

        for (Flight flight : flightList) {
            if (flight.getSegments().size() > 1) {
                for (Segment segment : flight.getSegments()) {
                    localDateTimeDeparture = segment.getDepartureDate();

                    if (cnt != 0 && localDateTimeArrival.plusHours(2).isBefore(localDateTimeDeparture)) {
                        System.out.println(flight);
                        newFlightList.remove(flight);
                    }

                    localDateTimeArrival = segment.getArrivalDate();
                    cnt++;
                }
            }
        }
        return newFlightList;
    }

}

