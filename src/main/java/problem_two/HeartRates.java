package problem_two;

import java.time.LocalDate;
import java.time.Period;

public class HeartRates {

    // Attributes
    private String firstName;
    private String lastName;
    private LocalDate dob;

    @Override
    public String toString() {
        return
                '\n'+ "First Name: " + firstName + '\n' +
                        "Last Name: " + lastName  + '\n' +
                        "Age: " + calculateAge() + '\n' +
                        "Date of birth: " + dob + '\n' +
                        "Maximum Heart Rate: " + calculateMaximumHeartRate()
                ;
    }

    // Constants
    public static final int RESTING_HEART_RATE = 70;
    public static final float LOWER_BOUNDARY = 0.5F;
    public static final float UPPER_BOUNDARY = 0.85F;

    public HeartRates(String fName, String lName, LocalDate dob){
        this.firstName = fName;
        this.lastName = lName;
        this.dob = dob;
    }

    public int calculateAge(){
        LocalDate today = LocalDate.now();
        Period age = Period.between(dob, today);
        return age.getYears();
    }

    public int calculateMaximumHeartRate(){
        int age = calculateAge();
        return (220 - age);
    }

    public void calculateTargetRateRange(){
        int averageHeartRate = calculateMaximumHeartRate() - RESTING_HEART_RATE;
        double lowerBoundaryTarget = (averageHeartRate*LOWER_BOUNDARY) + RESTING_HEART_RATE;
        double upperBoundaryTarget = (averageHeartRate*UPPER_BOUNDARY) + RESTING_HEART_RATE;

        System.out.printf("The Target Heart Range is between %f and %f", lowerBoundaryTarget, upperBoundaryTarget);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

}

