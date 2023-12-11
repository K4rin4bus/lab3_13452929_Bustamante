package org.example;

import java.util.Scanner;

public class Main {
    static boolean isAdminLoggerIn;// bandera para indicar usuario admin conectado

    public static void main(String[] args) {
        //aqui comienza el menu
        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 10;

        //Creando sistema
        //se debe crear algunos datos previos para operar con el sistema
        var s1 = "mySystem";
        System_Bustamante13452 system = new System_Bustamante13452(s1);
        int opInicio;
        int opRegister;
        //int opUser;
        //int opAdmin;

        do {
            printMenuIni();
            opInicio = input.nextInt();

            switch (opInicio) {
                case 1:  //Logear Usuario
                    System.out.println("Ingrese nombre de usuario y presione ENTER:");
                    var nUserLogin = input.next();
                    system.login(nUserLogin); //va a system a buscar usuario en lista
                    if(isAdminLoggerIn){  //bandera para saber que menu desplegar
                        //Bandera = true -> Admin
                        //mostrar menu user correspondiente

                    } else {
                        //Bandera = false -> User
                        //mostrar menu user correspondiente

                    }
                    System.out.println(system);


/*
                    List<String> keywords0p1 = new ArrayList<>();
                    keywords0p1.add("viajar");
                    keywords0p1.add("estudiar");
                    Option_Bustamante13452 op1 = new Option_Bustamante13452(0, "Hola", 0,0, keywords0p1);
                    Option_Bustamante13452 op2 = new Option_Bustamante13452(1, "HolaDos", 1,1, keywords0p1);
                    System.out.println(op1);
                    System.out.println(" ");

                    List<Option_Bustamante13452> opciones1 = new ArrayList<>();
                    opciones1.add(op1);

                    Flow_Bustamante13452 f1 = new Flow_Bustamante13452(0, "HolaFlow", opciones1);
                    f1.flowAddOption(op2);
                    System.out.println(f1);
*/ //opcion y flow
                    break;

                case 2:  //Registrar Usuario
                    do {
                        printMenuRegister();
                        opRegister = input.nextInt();

                        switch (opRegister) {
                            case 1: //crear user admin
                                System.out.println("Ingrese nombre de usuario y presione ENTER:");
                                var uName = input.next();
                                system.register(uName, true, false);
                                break;
                            case 2: //crear user normal
                                System.out.println("Ingrese nombre de usuario y presione ENTER:");
                                var uNameN = input.next();
                                system.register(uNameN, false, false);
                                break;
                            case 3:
                                System.out.println("Volviendo al menu usuario");
                                break;
                            default:
                                System.out.println(opRegister + " opción no valida! Intentalo nuevamente.");
                        }
                    } while (opRegister != 3);
                    break;

                case 0:
                    System.out.println("Saliendo del menu principal");
                    System.exit(0);
                    break;
                default:
                    System.out.println(opInicio + " opción no valida! Intentalo nuevamente.");
            }
        } while (opInicio != MENU_EXIT_OPTION);
    }

    private static void printMenuIni() {
        System.out.print("\n==================================\n");
        System.out.println("  Sistema de Chatbot - Inicio  ");
        System.out.print("==================================\n");
        System.out.print(" 1. Login Usuario. \n");
        System.out.print(" 2. Registro Usuario.\n");
        System.out.print(" 0. Exit\n");
        System.out.print("==================================\n");
        System.out.print("\nIngrese su opción: ");
    }

    private static void printMenuRegister() {
        System.out.print("\n=============================================\n");
        System.out.println("   Sistema de Chatbot - Registro Usuario  ");
        System.out.print("=============================================\n");
        System.out.print(" 1. Registrar usuario admin.\n");
        System.out.print(" 2. Registrar usuario normal.\n");
        System.out.print(" 3. Volver al menu principal\n");
        System.out.print("=============================================\n");
        System.out.print("\nIngrese su opción: ");
    }

  /*  private static void printMenuUser() {
        System.out.print("\n=============================================\n");
        System.out.println("   Sistema de Chatbot - Manu Usuario Normal ");
        System.out.print("=============================================\n");
        System.out.print("1. Create something \n");
        System.out.print("2. Modify something.\n");
        System.out.print("3. Sum 2 numbers.\n");
        System.out.print("4. Some option.\n");
        System.out.print("5. Exit\n");
        System.out.print("\nEnter your choice: ");
    }
    private static void printMenuAdmin() {
        System.out.print("\n=======================================================\n");
        System.out.println("  Sistema de Chatbot - Menu Usuario Administrador ");
        System.out.print("=======================================================\n");
        System.out.print("1. Crear Chatbot. \n");
        System.out.print("2. Modificar Chatbot.\n");
        System.out.print("3. Ejecutar un Chatbot.\n");
        System.out.print("4. Visualizar Chatbot Existentes en el Sistema.\n");
        System.out.print("5. Visualizar Chatbot con Flujos y Opciones Creadas.\n");
        System.out.print("6. Salir\n");
        System.out.print("\nEnter your choice: ");
    }*/

    /*
    private static void printMenuUser() {
        System.out.print("\n=============================================\n");
        System.out.println("   Sistema de Chatbot - Registro Usuario  ");
        System.out.print("=============================================\n");
        System.out.println("Main Menu\n");
        System.out.print("1. Create something \n");
        System.out.print("2. Modify something.\n");
        System.out.print("3. Sum 2 numbers.\n");
        System.out.print("4. Some option.\n");
        System.out.print("5. Exit\n");
        System.out.print("\nEnter your choice: ");
    }
*/ //Print menu principal
    /*
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
    */ //Opciones menu principal
}