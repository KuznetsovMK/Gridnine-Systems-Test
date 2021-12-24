package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.	вылет до текущего момента времени
 */

public class DepartureBeforeNow implements Filter {

    private final LocalDateTime localDateTime = LocalDateTime.now();

    @Override
    public List<Flight> filter(List<Flight> flightList) {

        System.out.println("1. Исключены перелеты с вылетами до текущего момента времени:");

        List<Flight> newFlightList = new ArrayList<>(flightList);

        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(localDateTime)) {
                    System.out.println(flight);
                    newFlightList.remove(flight);
                    break;
                }
            }
        }
        return newFlightList;
    }
}
