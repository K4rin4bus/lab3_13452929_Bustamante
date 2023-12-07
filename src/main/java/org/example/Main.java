 package org.example;

//Laboratorio 3 Paradigmas de la programación

 import java.util.Scanner;

 public class Main {
    public static void main(String[] args) {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            final int MENU_EXIT_OPTION = 10;
            var n0 = "";
            Filesystem_Bustamante13452 fileSystem = new Filesystem_Bustamante13452(n0);
            int choice;

            do {
                printMenu();
                choice = input.nextInt();

                switch (choice) {

                    case 1: //crear filesystem
                        System.out.println("Ingrese nombre de sistema a crear y luego presione ENTER:");
                        var n1 = input.next();
                        //Filesystem_Bustamante13452 fileSystem = new Filesystem_Bustamante13452(n1);
                        fileSystem = new Filesystem_Bustamante13452(n1);
                        System.out.println(fileSystem);
                        System.out.println("Sistema creado satisfactoriamente\n\n");
                        break;

                    case 2: //addDrive... agregar sin repetir letra de disco
                        System.out.println("Ingrese letra unidad de disco y luego presione ENTER:");
                        var vLetter = input.next();
                        System.out.println("Ingrese nombre de unidad de disco y luego presione ENTER:");
                        var vName = input.next();
                        System.out.println("Ingrese capacidad unidad de disco y luego presione ENTER:");
                        var vCapacity = input.nextInt();

                        fileSystem.addDrive(vLetter, vName, vCapacity);
                        System.out.println(fileSystem);
                        System.out.println("Unidad de disco agregada al sistema\n\n");
                        break;

                    case 3://addUser
                        System.out.println("Ingrese nombre de usuario y luego presione ENTER:");
                        var nUser = input.next();
                        fileSystem.register(nUser);
                        System.out.println(fileSystem);
                        System.out.println("Usuario registrado en sistema\n\n");
                        break;

                    case 4:// Login
                        System.out.println("Ingrese nombre de usuario y luego presione ENTER:");
                        var nUserLogin = input.next();
                        fileSystem.login(nUserLogin);
                        System.out.println(fileSystem);
                        System.out.println("Usuario Logeado en sistema\n\n");
                        break;

                    case 5:// Logoff
                        System.out.println("Ingrese nombre de usuario y luego presione ENTER:");
                        var nUserLogoff = input.next();
                        fileSystem.logoff(nUserLogoff);
                        System.out.println(fileSystem);
                        System.out.println("Usuario deslogeado en sistema\n\n");
                        break;

                    case 6:// SwitchDrive
                        System.out.println("Ingrese letra de unidad a fijar y luego presione ENTER:");
                        var vLetterSw = input.next();
                        fileSystem.switchDrive(vLetterSw);
                        System.out.println(fileSystem);
                        System.out.println("Unidad Fijada en sistema\n\n");
                        break;

                    case 10:
                        System.out.println("Bye... Que la Fuerza te acompañe");
                        System.exit(0);
                        break;
                    default:
                        System.out.println(choice + " opcion no valida! Ingrese una opcion valida.");

                }
            } while (choice != MENU_EXIT_OPTION);
        }

        private static void printMenu() {
            System.out.println("Main Menu\n");
            System.out.print(" 1. Crear Filesystem. \n");
            System.out.print(" 2. Crear Unidad de Disco en Filesystem.\n");
            System.out.print(" 3. Crear Usuario en Filesystem.\n");
            System.out.print(" 4. Login.\n");
            System.out.print(" 5. Logoof.\n");
            System.out.print(" 6. Fijar Unidad de Disco.\n");
            System.out.print("10. Exit\n");
            System.out.print("\nIngrese su opcion: ");
        }
    }
}