package problem_two;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter your first name: ");
        String fName = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        String lName = scanner.nextLine();
        LocalDate birthday;
        while (true) {
            System.out.println("Please enter your birthday "
                    + "in yyyy-MM-dd format (e.g. 1980-9-28): ");
            String dob = scanner.nextLine();
            try {
                birthday = LocalDate.parse(dob, formatter);
                break;

            } catch(DateTimeParseException e) {
                System.out.println("Error! Please try again");
            }
        }
        HeartRates hr1 = new HeartRates(fName,lName,birthday);
        hr1.calculateTargetRateRange();
        System.out.println(hr1);

    }
}

