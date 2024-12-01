package problem_four;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String response;
        String input;
        do {
            System.out.println(
                    """
                            Enter C for Circle
                            Enter R for Rectangle
                            Enter T for Triangle
                            \n
                    """
            );
            input = (sc.nextLine()).toUpperCase();

            if(input.equals("R")){
                System.out.println("Enter the width of the Rectange ");
                double width = sc.nextDouble();
                System.out.println("Enter the length of the Rectange: ");
                double length = sc.nextDouble();
                Rectangle r1 = new Rectangle(width, length);
                System.out.printf("The Area of the Rectangle is: %.2f", r1.computeArea());
            } else if (input.equals("T")) {
                System.out.println("Enter height of the Triangle: ");
                double height = sc.nextDouble();
                System.out.println("Enter the base of the triangle: ");
                double base = sc.nextDouble();
                Rectangle t1 = new Rectangle(height, base);
                System.out.printf("The Area of the Triangle is: %.2f", t1.computeArea());

            }

            else if(input.equals("C")){
                System.out.println("Enter Radius of the Circle: ");
                double radius = sc.nextDouble();
                Rectangle c1 = new Rectangle(radius, 0.9);
                System.out.printf("The Area of the Circle is: %.2f", c1.computeArea());

            }

            else {
                System.out.println("Invalid Choice. Please Try again");
                System.out.println(
                        """
                                Enter C for Circle
                                Enter R for Rectangle
                                Enter T for Triangle
                        """
                );
                input = sc.nextLine();
            }

            System.out.println("\n Do you want to continue (y/n)");
            response = (sc.nextLine()).toLowerCase();


        }
        while (response.equals("y"));
    }
}
