package problem_three;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Event {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    public Event(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    public static LocalDate getLocalDateFromString(String date){
        //Convert the input date string to LocalDate
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
    public static LocalTime getLocalTimeFromString(String time){
        //Convert the input time string to LocalTime
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    }
    public String printEventDayofWeek(){
        return switch (date.getDayOfWeek()){
            case MONDAY -> "Event Day of the week is on: Monday";
            case TUESDAY -> "Event Day of the week is on: Tuesday";
            case WEDNESDAY -> "Event Day of the week is on: Wednesday";
            case THURSDAY -> "Event Day of the week is on: Thursday";
            case FRIDAY -> "Event Day of the week is on: Friday";
            case SATURDAY -> "Event Day of the week is on: Saturday";
            case SUNDAY -> "Event Day of the week is on: Sunday";
        };

    }
    public String printIsLeapYear(){
        return date.isLeapYear()? "Event is in a leap year" : "Event is not in a leap year";
    }
    public long calculateDaysToEvent(){
        LocalDate today = LocalDate.now();
        return ChronoUnit.DAYS.between(today, date);
    }
    public String formatEventDetails(ZonedDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy @ HH:mm '['VV']'");
        return dateTime.format(formatter);
    }
}
