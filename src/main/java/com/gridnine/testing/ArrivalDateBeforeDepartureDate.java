package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.	имеются сегменты с датой прилёта раньше даты вылета
 */

public class ArrivalDateBeforeDepartureDate implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flightList) {

        System.out.println("2. Исключены перелеты, где имеются сегменты с датой прилёта раньше даты вылета:");

        List<Flight> newFlightList = new ArrayList<>(flightList);

        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    System.out.println(flight);
                    newFlightList.remove(flight);
                    break;
                }
            }
        }

        return newFlightList;
    }
}

