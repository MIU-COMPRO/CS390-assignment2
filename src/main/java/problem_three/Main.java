package problem_three;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the COMPRO event scheduler");
        //Allow users to input the event name, date and time for a new event.
        Scanner input  = new Scanner(System.in);
        String choice = "Y";
        while (choice.equalsIgnoreCase("Y")) {
            //Input the event details
            System.out.println("Enter the event name:");
            String eventName = input.nextLine();

            System.out.println("Enter the event date (yyyy-MM-dd):");
            String eventDate = input.nextLine();

            System.out.println("Enter the event time (HH:mm):");
            String eventTime = input.nextLine();

            //Display the day of the week (Eg: Sunday, Monday) for the event date and check if it
            //is in a leap year.
            LocalDate date = getLocalDateFromString(eventDate);
            LocalTime time = getLocalTimeFromString(eventTime);
            //Event day of the week
            printEventDayofWeek(date.getDayOfWeek());
            System.out.println("Is it in a Leap Year: " + date.isLeapYear());
            //Create an instance of the Event class with the entered event details.
            Event event = new Event(eventName, date, time);
            //Calculate and display the number of days from the current date to the event date.
            long daysToEvent = calculateDaysToEvent(date);
            System.out.printf("Days to event: %d days.%n", daysToEvent);
            //Display the current date and time, including the default system time zone
            //Example Sunday, October 20, 2024 @ 10:30 [America/Chicago]
            ZonedDateTime now = ZonedDateTime.now();
            System.out.println("Current date and time: " + formatEventDetails(now));

            //Display the event date and time, including the default system time zone
            //Example Sunday, October 20, 2024 @ 10:30 [America/Chicago]
            ZonedDateTime eventDateTime = ZonedDateTime.of(date, time, ZoneId.systemDefault());
            System.out.println("Event date and time: " + formatEventDetails(eventDateTime));
            //Convert the event's date and time from the system's default time zone to any other,
            //specified time zone entered by the user.
            System.out.println("Do you want to convert to a different time zone? (Y|N)");
            String answerTimeZone = input.nextLine();
            int choiceTimeZone;
            String targetTimeZone;
            if(answerTimeZone.equalsIgnoreCase("Y")) {
                printInDifferentTimeZone();
                System.out.print("Your Choice:");
                choiceTimeZone = input.nextInt();
                input.nextLine(); // Consume the leftover newline character
                targetTimeZone = switch(choiceTimeZone){
                    case 1 -> "America/Panama";
                    case 2 -> "America/Chicago";
                    case 3 -> "America/Indiana/Indianapolis";
                    case 4 -> "America/Santiago";
                    case 5 -> "America/Phoenix";
                    default -> "America/North_Dakota/Center";
                };
                String result = convertTimeZone(eventDateTime, targetTimeZone);
                System.out.println("Converted Time Zone: " + result);
            }
            System.out.println("Do you want to schedule another event? (Y/N)");
            choice = input.nextLine();
        }

    }
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static void printInDifferentTimeZone() {
            System.out.println("Select the target time zone from the list below Ex: number 2 for America/Chicago");
            //List of available time zones
            System.out.println("""
                    1.America/Panama
                    2.America/Chicago
                    3.America/Indiana/Indianapolis
                    4.America/Santiago
                    5.America/Phoenix
                    """);
    }
    public static LocalDate getLocalDateFromString(String date){
        //Convert the input date string to LocalDate
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
    public static LocalTime getLocalTimeFromString(String time){
        //Convert the input time string to LocalTime
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    }
    public static long calculateDaysToEvent(LocalDate eventDate){
        LocalDate today = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(today, eventDate);
        return daysBetween;
    }
    public static String formatEventDetails(ZonedDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy @ HH:mm '['VV']'");// Replace underscores for readability
        return dateTime.format(formatter);
    }
    public static String convertTimeZone(ZonedDateTime eventDateTime, String specifiedTimeZone) {
        try {
            // Parse the target time zone
            ZoneId targetZoneId = ZoneId.of(specifiedTimeZone);

            // Convert the event date and time to the target time zone
            ZonedDateTime convertedDateTime = eventDateTime.withZoneSameInstant(targetZoneId);

            // Format the converted date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy @ HH:mm '['VV']'");
            return convertedDateTime.format(formatter);

        } catch (DateTimeException e) {
            // Handle invalid time zone ID
            return "Invalid time zone ID: " + specifiedTimeZone;
        }
    }
    public static void printEventDayofWeek(DayOfWeek day){
        switch (day){
            case MONDAY -> System.out.println("Event Day of the week is on: Monday");
            case TUESDAY -> System.out.println("Event Day of the week is on: Tuesday");
            case WEDNESDAY -> System.out.println("Event Day of the week is on: Wednesday");
            case THURSDAY -> System.out.println("Event Day of the week is on: Thursday");
            case FRIDAY -> System.out.println("Event Day of the week is on: Friday");
            case SATURDAY -> System.out.println("Event Day of the week is on: Saturday");
            case SUNDAY -> System.out.println("Event Day of the week is on: Sunday");
        }

    }
}
