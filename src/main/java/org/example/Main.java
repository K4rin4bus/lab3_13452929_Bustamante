package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> keywords0p1 = new ArrayList<>();
        keywords0p1.add("viajar");
        keywords0p1.add("estudiar");
        Option op1 = new Option(0, "Hola", 0,0, keywords0p1);
        Option op2 = new Option(1, "HolaDos", 1,1, keywords0p1);
        System.out.println(op1);
        System.out.println(" ");

        List<Option> opciones1 = new ArrayList<>();
        opciones1.add(op1);

        Flow f1 = new Flow(0, "HolaFlow", opciones1);
        f1.flowAddOption(op2);
        System.out.println(f1);


        //aqui comienza el menu
        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 5;

        int choice;

        do {
            printMenu();
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    //do something
                    break;

                case 2:
                    //do something
                    break;

                case 3:
                    System.out.println("Sum 2 numbers");
                    System.out.println("Ingrese un número int y luego presione ENTER:");
                    var n1 = input.nextInt();
                    System.out.println("Ingrese otro número int y luego presione ENTER:");
                    var n2 = input.nextInt();
                    int sum = n1 + n2;
                    System.out.println("La suma es: " + sum);
                    break;

                case 4:
                    //do something
                    break;

                case 5:
                    System.out.println("Bye.. Que la Fuerza te acompañe");
                    System.exit(0);
                    break;
                default:
                    System.out.println(choice + " is not a valid option! Please select correct option.");

            }
        } while (choice != MENU_EXIT_OPTION);
    }

    private static void printMenu() {
        System.out.println("Main Menu\n");
        System.out.print("1. Create something \n");
        System.out.print("2. Modify something.\n");
        System.out.print("3. Sum 2 numbers.\n");
        System.out.print("4. Some option.\n");
        System.out.print("5. Exit\n");
        System.out.print("\nEnter your choice: ");
    }
}