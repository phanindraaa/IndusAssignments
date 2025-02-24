package com.indus.training.ui;

import com.indus.training.core.domain.CalcEncInp;
import com.indus.training.core.domain.CalcEncOut;
import com.indus.training.core.impl.CalcEncr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CalciUi {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CalcEncInp calIn = new CalcEncInp();
        CalcEncr calculator = new CalcEncr();

        while (true) {
            System.out.println("********************");
            System.out.println("* Calculator Menu: *");
            System.out.println("* 1. Add           *");
            System.out.println("* 2. Subtract      *");
            System.out.println("* 3. Multiply      *");
            System.out.println("* 4. Divide        *");
            System.out.println("* 5. Exit          *");
            System.out.println("*Enter your choice:*");
            System.out.println("********************");

            int choice;
            double num1, num2;

            try {
                choice = Integer.parseInt(reader.readLine());

                if (choice == 5) {
                    System.out.println("Exiting the program.");
                    break;
                }

                System.out.print("Enter first number: ");
                num1 = Double.parseDouble(reader.readLine());
                calIn.setPraam1(num1);

                System.out.print("Enter second number: ");
                num2 = Double.parseDouble(reader.readLine());
                calIn.setPraam2(num2);

                CalcEncOut calOut = null;

                switch (choice) {
                    case 1:
                        calOut = calculator.Addition(calIn);
                        System.out.println("Result: " + calOut.getResult());
                        break;
                    case 2:
                        calOut = calculator.Subtract(calIn);
                        System.out.println("Result: " + calOut.getResult());
                        break;
                    case 3:
                        calOut = calculator.Multiply(calIn);
                        System.out.println("Result: " + calOut.getResult());
                        break;
                    case 4:
                        if (num2 != 0) {
                            calOut = calculator.Division(calIn);
                            System.out.println("Result: " + calOut.getResult());
                        } else {
                            System.out.println("Error! Division by zero.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IOException e) {
                System.out.println("Error reading input.");
            }
        }
    }
}
