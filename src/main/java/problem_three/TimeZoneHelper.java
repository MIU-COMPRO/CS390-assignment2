package problem_three;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class TimeZoneHelper {

    private TimeZoneHelper(){
        throw new IllegalStateException("Utility class");
    }
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
}
