package com.gridnine.testing;

import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartureBeforeNowTest extends TestCase {

    public void testFilter1() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Segment segment = new Segment(localDateTime.minusHours(1), localDateTime.plusHours(1));
        Flight flight = new Flight(List.of(segment));

        List<Flight> flightList = new ArrayList<>(List.of(flight));
        List<Flight> expected = new ArrayList<>();

        DepartureBeforeNow departureBeforeNow = new DepartureBeforeNow();
        List<Flight> actual = departureBeforeNow.filter(flightList);

        assertEquals(expected,actual);
    }

    public void testFilter2() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Segment segment = new Segment(localDateTime.minusHours(2), localDateTime.minusHours(1));
        Segment segment2 = new Segment(localDateTime.plusHours(1), localDateTime.plusHours(2));
        Flight flight = new Flight(List.of(segment, segment2));

        List<Flight> flightList = new ArrayList<>(List.of(flight));
        List<Flight> expected = new ArrayList<>();

        DepartureBeforeNow departureBeforeNow = new DepartureBeforeNow();
        List<Flight> actual = departureBeforeNow.filter(flightList);

        assertEquals(expected,actual);
    }

    public void testFilter3() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Segment segment = new Segment(localDateTime.minusDays(1), localDateTime.minusDays(1).plusHours(1));
        Flight flight = new Flight(List.of(segment));

        Segment segment2 = new Segment(localDateTime.plusDays(1), localDateTime.plusDays(1).plusHours(1));
        Flight flight2 = new Flight(List.of(segment2));

        List<Flight> flightList = new ArrayList<>(List.of(flight, flight2));
        List<Flight> expected = new ArrayList<>(List.of(flight2));

        DepartureBeforeNow departureBeforeNow = new DepartureBeforeNow();
        List<Flight> actual = departureBeforeNow.filter(flightList);

        assertEquals(expected,actual);
    }
}