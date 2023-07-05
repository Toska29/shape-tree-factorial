package main.questionThree;

import java.util.Scanner;

public class ShapeDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Menu-" + "\n" + "Enter your shape choice: ");
        String shape = input.nextLine();
        String response = "yes";

        while (response.equalsIgnoreCase("Yes")){

            if(shape.equalsIgnoreCase("Rectangle")){
                Rectangle rectangle = new Rectangle();
                System.out.print("Enter the length: ");
                double length = input.nextDouble();
                rectangle.setLength(length);

                System.out.print("Enter the width: ");
                double width = input.nextDouble();
                rectangle.setWidth(width);
                System.out.println("Area of Rectangle: " + rectangle.area());
                System.out.println("Perimeter of Rectangle: " + rectangle.perimeter());

            } else if (shape.equalsIgnoreCase("Square")) {
                Square square = new Square();
                System.out.print("Enter the side: ");
                double side = input.nextDouble();
                square.setSide(side);
                System.out.println("Area of Square: " + square.area());
                System.out.println("Perimeter of Square: " + square.perimeter());

            } else if (shape.equalsIgnoreCase("Circle")) {
                Circle circle = new Circle();
                System.out.print("Enter the radius: ");
                double radius = input.nextDouble();
                circle.setRadius(radius);
                System.out.println("Area of Circle: " + circle.area());
                System.out.println("Perimeter of Circle: " + circle.perimeter());
            } else {
                System.out.println("This is not recognized shape. Allowed shapes are: Circle, Square, Rectangle");
            }

            System.out.print("Do you want to continue?" + "\n" +  "Enter Yes to continue  or No to exit: ");
            response = input.next();
            if (response.equalsIgnoreCase("No")) break;

            System.out.print("Menu-" + "\n" + "Enter your shape choice: ");
            shape = input.next();
        }

    }
}
