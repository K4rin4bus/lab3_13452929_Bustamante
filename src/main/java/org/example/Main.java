 package org.example;
 import java.util.Scanner;
//Laboratorio 3 Paradigmas de la programación

 import java.util.Scanner;

 public class Main {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         final int MENU_EXIT_OPTION = 10;
         var n0 = "";
         //Filesystem_Bustamante13452 fileSystem = new Filesystem_Bustamante13452(n0);
         int choice;

         do {
             printMenu();
             choice = input.nextInt();

             switch (choice) {

                 case 1: //crear filesystem
                     System.out.println("Ingrese nombre de sistema a crear y luego presione ENTER:");
                    var n1 = input.next();
                     /*//Filesystem_Bustamante13452 fileSystem = new Filesystem_Bustamante13452(n1);
                     fileSystem = new Filesystem_Bustamante13452(n1);
                     System.out.println(fileSystem);
                     System.out.println("Sistema creado satisfactoriamente\n\n");*/
                     break;
                 case 2:
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