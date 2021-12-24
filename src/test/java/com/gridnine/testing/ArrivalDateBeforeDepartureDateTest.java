package com.gridnine.testing;

import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ArrivalDateBeforeDepartureDateTest extends TestCase {

    public void testFilter1() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Segment segment = new Segment(localDateTime.plusHours(1), localDateTime.minusHours(1));
        Flight flight = new Flight(List.of(segment));

        List<Flight> flightList = new ArrayList<>(List.of(flight));
        List<Flight> expected = new ArrayList<>();

        ArrivalDateBeforeDepartureDate arrivalDateBeforeDepartureDate = new ArrivalDateBeforeDepartureDate();
        List<Flight> actual = arrivalDateBeforeDepartureDate.filter(flightList);

        assertEquals(expected,actual);
    }

    public void testFilter2() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Segment segment = new Segment(localDateTime.minusHours(2), localDateTime.minusHours(1));
        Segment segment2 = new Segment(localDateTime.plusHours(1), localDateTime);

        Flight flight = new Flight(List.of(segment, segment2));

        List<Flight> flightList = new ArrayList<>(List.of(flight));
        List<Flight> expected = new ArrayList<>();

        ArrivalDateBeforeDepartureDate arrivalDateBeforeDepartureDate = new ArrivalDateBeforeDepartureDate();
        List<Flight> actual = arrivalDateBeforeDepartureDate.filter(flightList);

        assertEquals(expected,actual);
    }
}