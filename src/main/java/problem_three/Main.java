package problem_three;

import java.time.*;
import java.time.format.DateTimeParseException;
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
            LocalDate eventDate = null;
            LocalTime eventTime = null;
            // Validate date input
            while (eventDate == null) {
                System.out.println("Enter the event date (yyyy-MM-dd):");
                String dateInput = input.nextLine();
                try {
                    eventDate = Event.getLocalDateFromString(dateInput);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
                }
            }
            // Validate time input
            while (eventTime == null) {
                System.out.println("Enter the event time (HH:mm):");
                String timeInput = input.nextLine();
                try {
                    eventTime = Event.getLocalTimeFromString(timeInput);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid time format. Please enter the time in HH:mm format.");
                }
            }
            //Display the day of the week (Eg: Sunday, Monday) for the event date and check if it
            //is in a leap year.
            //Create an instance of the Event class with the entered event details.
            Event event = new Event(eventName, eventDate, eventTime);
            //Event day of the week
            System.out.println(event.printEventDayofWeek());
            //Check if event is in a leap year
            System.out.println(event.printIsLeapYear());
            //Calculate and display the number of days from the current date to the event date.
            System.out.printf("Days to the event: %d days.%n", event.calculateDaysToEvent());
            //Display the current date and time, including the default system time zone
            //Example Sunday, October 20, 2024 @ 10:30 [America/Chicago]
            System.out.println("Current date and time: " + event.formatEventDetails(ZonedDateTime.now()));
            //Display the event date and time, including the default system time zone
            //Example Sunday, October 20, 2024 @ 10:30 [America/Chicago]
            ZonedDateTime eventDateTime = ZonedDateTime.of(event.getDate(), event.getTime(), ZoneId.systemDefault());
            System.out.println("Event date and time: " + event.formatEventDetails(eventDateTime));
            //Convert the event's date and time from the system's default time zone to any other,
            //specified time zone entered by the user.
            System.out.println("Do you want to convert to a different time zone? (Y|N)");
            String answerTimeZone = input.nextLine();
            int choiceTimeZone;
            String targetTimeZone;
            if(answerTimeZone.equalsIgnoreCase("Y")) {
                TimeZoneHelper.printInDifferentTimeZone();
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
                String result = TimeZoneHelper.convertTimeZone(eventDateTime, targetTimeZone);
                System.out.println("Converted Time Zone: " + result);
            }
            System.out.println("Do you want to schedule another event? (Y/N)");
            choice = input.nextLine();
        }
        input.close();
    }
}
