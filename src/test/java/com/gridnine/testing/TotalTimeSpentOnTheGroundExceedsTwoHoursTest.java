package com.gridnine.testing;

import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TotalTimeSpentOnTheGroundExceedsTwoHoursTest extends TestCase {

    public void testFilter1() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Segment segment1 = new Segment(localDateTime.plusDays(3), localDateTime.plusDays(3).plusHours(2));
        Segment segment2 = new Segment(localDateTime.plusDays(3).plusHours(3), localDateTime.plusDays(3).plusHours(4));
        Segment segment3 = new Segment(localDateTime.plusDays(3).plusHours(7), localDateTime.plusDays(3).plusHours(8));
        Flight flight = new Flight(List.of(segment1, segment2, segment3));

        List<Flight> flightList = new ArrayList<>(List.of(flight));
        List<Flight> expected = new ArrayList<>();

        TotalTimeSpentOnTheGroundExceedsTwoHours spentOnTheGroundExceedsTwoHours = new TotalTimeSpentOnTheGroundExceedsTwoHours();
        List<Flight> actual = spentOnTheGroundExceedsTwoHours.filter(flightList);

        assertEquals(expected,actual);
    }
}