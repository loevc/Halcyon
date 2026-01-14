package org.loevc.halcyon.other;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class CheckInRequireTest {

    private static String findNextDay(List<String> checkInDays, String expeditingTime) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = expeditingTime.length() == 5
                ? DateTimeFormatter.ofPattern("HH:mm")
                : DateTimeFormatter.ofPattern("HH:mm:ss");
        for (String dayStr : checkInDays) {
            LocalDate date = LocalDate.parse(dayStr, dateFormatter);
            LocalTime time = LocalTime.parse(expeditingTime, timeFormatter);
            LocalDateTime candidate = LocalDateTime.of(date, time);
            if (candidate.isAfter(now)) {
                return dayStr;
            }
        }
        return null;
    }


    private static Date toDate(String dayStr, String expeditingTime) {
        if (expeditingTime.length() == 5) {
            expeditingTime = expeditingTime + ":00";
        }
        String dateTimeStr = dayStr + " " + expeditingTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateTimeStr);
        } catch (ParseException e) {
            log.error("check-in expediting_time_to_date func convert failed :", e);
            throw new RuntimeException(e);
        }
        return date;
    }

    public static void main(String[] args) {
//        System.err.println(toDate("2025-09-21", "18:00:00"));
        System.err.println(findNextDay(new ArrayList<String>() {{
            add("2025-09-07");
            add("2025-09-09");
        }}, "18:00"));
    }


}
