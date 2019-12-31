package com.calculator;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true)
        {
            out.println("Choose operation:");
            out.println(ConsoleColors.CYAN + "1) + ");
            out.println("2) - ");
            out.println("3) * ");
            out.println("4) / ");
            out.println("5) Exit" + ConsoleColors.RESET);
            int number = input.nextInt();
            double[] numbers = {};
            if (number != 5) {
                numbers = numbers();
            }
              switch (number){
                case 1:
                    out.println(ConsoleColors.YELLOW_BOLD + "Result: " + sum(numbers) + ConsoleColors.RESET);
                    break;
                case 2:
                    out.println(ConsoleColors.YELLOW_BOLD + "Result: " + difference(numbers) + ConsoleColors.RESET);
                    break;
                case 3:
                    out.println(ConsoleColors.YELLOW_BOLD + "Result" + multiply(numbers) + ConsoleColors.RESET);
                    break;
                case 4:
                    divide(numbers);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    out.println(ConsoleColors.RED + "Choose from four operations" + ConsoleColors.RESET);
                    break;
            }
        }

    }
    private static void divide(double ...numbers) {
        double div = numbers[0];
        boolean isSuccess = false;
        for (int i = 1; i < numbers.length; i++){
            if (numbers[i] == 0){
                isSuccess = false;
            }else {
                div /= numbers[i];
                isSuccess = true;
            }
        }
        if (isSuccess) {
            out.println(div);
        }else {
            out.println("Can't divide by zero");
        }
    }

    private static double multiply(double ...numbers) {
        double mul = 1;
        for (int i = 0; i < numbers.length; i++){
            mul*=numbers[i];
        }
        return mul;
    }

    private static double difference(double ...b) {

        double difference = b[0];
        for (int i = 1; i<b.length; i++ ){

            difference -=  b[i];
        }
        return difference;
    }

    private static double[] numbers(){
        out.println(ConsoleColors.GREEN_BRIGHT + "How much numbers do you want to add?" + ConsoleColors.RESET);
        Scanner input = new Scanner(System.in);
        int numbersToAdd = input.nextInt();
        double[] numbers = new double[numbersToAdd];
        out.printf("Pls set: %d numbers \n", numbersToAdd);
        for (int i = 0; i < numbersToAdd; i++){
            out.printf("Set number - %d \n", i+1);
            double number = input.nextDouble();
            numbers[i] = number;
        }
        return numbers;
    }

    private static double sum(double ...b) {
        double sum = 0;
        for (int i = 0; i<b.length; i++ ){
            sum+=b[i];
        }
        return sum;
    }
}
