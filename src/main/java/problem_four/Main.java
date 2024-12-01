package problem_four;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String response;
        do {
            String input;
            System.out.println("""
                   Enter C for Circle
                   Enter R for Rectangle
                   Enter T for Triangle
                   """);
            input = (sc.nextLine()).toUpperCase();

            switch (input) {
                case "R" -> {
                    System.out.println("Enter the width of the Rectangle ");
                    double width = sc.nextDouble();
                    System.out.println("Enter the length of the Rectangle: ");
                    double length = sc.nextDouble();
                    Rectangle r1 = new Rectangle(width, length);
                    System.out.printf("The Area of the Rectangle is: %.2f \n", r1.computeArea());
                    System.out.println("Do you want to continue (y/n)");
                    sc.nextLine();
                }
                case "T" -> {
                    System.out.println("Enter height of the Triangle: ");
                    double height = sc.nextDouble();
                    System.out.println("Enter the base of the triangle: ");
                    double base = sc.nextDouble();
                    Triangle t1 = new Triangle(height, base);
                    System.out.printf("The Area of the Triangle is: %.2f \n", t1.computeArea());
                    System.out.println("Do you want to continue (y/n)");
                    sc.nextLine();
                }
                case "C" -> {
                    System.out.println("Enter Radius of the Circle: ");
                    double radius = sc.nextDouble();
                    Circle c1 = new Circle(radius);
                    System.out.printf("The Area of the Circle is: %.2f \n", c1.computeArea());
                    System.out.println("Do you want to continue (y/n)");
                    sc.nextLine();
                }
                default -> {
                    System.out.println("Invalid Choice. Please Try again");
                    System.out.println("Do you want to continue (y/n)");
                }
            }

            response = (sc.nextLine()).toLowerCase();

        }
        while (response.equals("y"));
        sc.close();
    }
}
