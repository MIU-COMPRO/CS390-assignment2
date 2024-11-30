package problem_three;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
    private String name;
    private LocalDate date;
    private LocalTime time;

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
//function to Format Event Details
    //Eg: Sunday, October 20, 2024 @ 10:30 [America/Chicago]

    //Time Zone Conversion function


}
