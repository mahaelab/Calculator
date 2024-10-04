package org.example;

import java.util.Scanner;
//test 1
public class Calc {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        Calc calculator = new Calc();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number:");
        int first = scanner.nextInt();

        System.out.println("Enter second number:");
        int second = scanner.nextInt();

        System.out.println("Choose an operation: Add, Subtract, Multiply, Divide");
        String operation = scanner.next();

        double result = 0;
        switch (operation.toLowerCase()) {
            case "add":
                result = calculator.add(first, second);
                break;
            case "subtract":
                result = calculator.subtract(first, second);
                break;
            case "multiply":
                result = calculator.multiply(first, second);
                break;
            case "divide":
                result = calculator.divide(first, second);
                break;
            default:
                System.out.println("Invalid operation. Please choose Add, Subtract, Multiply, or Divide.");
                return;
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}
