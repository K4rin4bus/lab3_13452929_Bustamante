package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 10;

        //Creando sistema
        var s1 = "mySystem";
        System_Bustamante13452 system = new System_Bustamante13452(s1);

        List<String> keywordsOpcion = new ArrayList<>();// Lista de palabras claves
        List<Option_Bustamante13452> opcion = new ArrayList<>(); //lista de opciones
        List<Flow_Bustamante13452> flows = new ArrayList<>(); // Lista de Flujos
        List<Chatbot_Bustamante13452> chatbots = new ArrayList<>(); //Lista de Chatbots

        /* Inicio Carga de datos duros al sistema  */

        //Creo Keywords
        List<String> keywordsOp1 = Arrays.asList("viajar", "pasatiempos");
        List<String> keywordsOp2 = Arrays.asList("estudiar", "postgrado");
        List<String> keywordsOp3 = Arrays.asList("New York", "Paris");
        List<String> keywordsOp4 = Arrays.asList("Central", "Museos");
        //Creo opciones
        Option_Bustamante13452 op1 = new Option_Bustamante13452(0, "Viajar", 1, 1, keywordsOp1);
        Option_Bustamante13452 op2 = new Option_Bustamante13452(1, "Estudiar", 1, 1, keywordsOp2);
        Option_Bustamante13452 op3 = new Option_Bustamante13452(2, "Donde Te gustaria Ir", 1, 1,keywordsOp3);
        Option_Bustamante13452 op4 = new Option_Bustamante13452(3, "Que atractivos te gustaria visitar", 1, 1, keywordsOp4);
        //agregar opciones a lista de opciones
        opcion.add(op1);
        opcion.add(op2);
        opcion.add(op3);
        opcion.add(op4);
        System.out.println("\n" + op1 + "\n" + op2 + "\n" + op3 + "\n" + op4);
        System.out.println("\n" + opcion);



        //Lista de opciones Flujo Inicial
        List<Option_Bustamante13452> opFinicial = new ArrayList<>();
        opFinicial.add(op1);
        Flow_Bustamante13452 fInicial = new Flow_Bustamante13452(0, "Flujo Principal", opFinicial);
        fInicial.flowAddOption(op2);
        System.out.println(fInicial);

        List<Option_Bustamante13452> opViajar = new ArrayList<>();
        opViajar.add(op3);

        List<Option_Bustamante13452> opLugares = new ArrayList<>();
        opLugares.add(op4);

        Flow_Bustamante13452 fViajar = new Flow_Bustamante13452(1, "Flujo Viajar", opViajar);
        Flow_Bustamante13452 fLugares = new Flow_Bustamante13452(2, "Flujo Lugares", opLugares);
        flows.add(fViajar);
        flows.add(fLugares);

        //Flow_Bustamante13452 vFlow = new Flow_Bustamante13452(vIdFlow, vMsgFlow, opcion);
        //flows.add(vFlow);


/*



        Chatbot_Bustamante13452 ChatFinicial = new Chatbot_Bustamante13452(0, "Inicial", "Bienvenido", 1, fInicial);
        Chatbot_Bustamante13452 ChatFviajar = new Chatbot_Bustamante13452(1, "Viajes", "Bienvenido as Viajar", 2, List.of(fViajar));
        Chatbot_Bustamante13452 ChatFLugares = new Chatbot_Bustamante13452(2, "Lugares", "Bienvenido a Lugares que hablan", 3, List.of(fLugares));




        */
        /* Fin Cargar datos duros sistema  */

        int opInicio;
        int opRegister;
        int opAdmin;
        int opUser;
        int opChatbot;
        int opModChatbot;

        do {
            printMenuIni();
            opInicio = input.nextInt();

            switch (opInicio) {
                case 1:  //Logear Usuario
                    System.out.println("Ingrese nombre de usuario y presione ENTER:");
                    var nUserLogin = input.next();
                    system.login(nUserLogin); //va a system a buscar usuario en lista
                    boolean isAdminLoggerIn = system.login(nUserLogin);

                    if(isAdminLoggerIn){  //bandera para saber que menu desplegar

                        do {
                            printMenuAdmin();
                            opAdmin = input.nextInt();

                            switch (opAdmin) {
                                case 1: //Crear Chatbot.
                                    System.out.println(" Para crear un Chatbot antes debe crear un Flujo y sus Opciones,");
                                    System.out.println(" desea hacerlo? construyalo siguiendo numeros del menu");

                                    do {
                                        mostrarMenuChatbot();
                                        opChatbot = input.nextInt();

                                        switch (opChatbot) {
                                            case 1: //Crear Opcion
                                                boolean continuar = true;
                                                keywordsOpcion.clear();//limpiar lista de palabras claves
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("          Creando Opcion    -    Sistema Chatbot.");
                                                System.out.print("=======================================================\n");
                                                while (continuar) {
                                                    System.out.println("Ingrese Keyword para la opcion, presione ENTER o escriba 'fin' para salir:");
                                                    String nKeywordOp = input.nextLine();
                                                    if (nKeywordOp.equalsIgnoreCase("fin")){
                                                        continuar = false;
                                                    }else{
                                                        keywordsOpcion.add(nKeywordOp);//lista de keywords
                                                    }
                                                }

                                                System.out.println("Ingrese codigo opcion, presione ENTER:");
                                                var vCodOp = input.nextInt();
                                                System.out.println("Ingrese mensaje opcion, presione ENTER:");
                                                var vMsgOp = input.next();
                                                System.out.println("Ingrese Codigo Link Chatbot, presione ENTER:");
                                                var vCodLinkChatbotOp = input.nextInt();
                                                System.out.println("Ingrese Codigo Link Initial Flow, presione ENTER:");
                                                var vCodLinkFlowIniOp = input.nextInt();

                                                // pasar datos a clase option
                                                Option_Bustamante13452 vOpcion = new Option_Bustamante13452(vCodOp, vMsgOp, vCodLinkChatbotOp,vCodLinkFlowIniOp, keywordsOpcion);
                                                opcion.add(vOpcion);
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("  Mostrando contenido de opcion creada: \n");
                                                System.out.println(opcion);
                                                break;

                                            case 2: //Crear Flujo.
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("          Creando Flujo    -    Sistema Chatbot.");
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("Ingrese IdFlow, presione ENTER:");
                                                var vIdFlow = input.nextInt();
                                                System.out.println("Ingrese mensaje Flow, presione ENTER:");
                                                var vMsgFlow = input.next();
                                                Flow_Bustamante13452 vFlow = new Flow_Bustamante13452(vIdFlow, vMsgFlow, opcion);
                                                flows.add(vFlow);
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("Mostrando contenido de flujo creado mas opcion: \n");
                                                System.out.println(flows);
                                                break;

                                            case 3: //Crear Chatbot.
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("          Creando Chatbot    -    Sistema Chatbot.");
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("Ingrese Chatbot Id, presione ENTER:");
                                                var vIdChatbot = input.nextInt();
                                                System.out.println("Ingrese nombre del Chatbot, presione ENTER:");
                                                var vNameChatbot = input.next();
                                                System.out.println("Ingrese mensaje bienvenida Chatbot, presione ENTER:");
                                                var vMsgChatbot = input.next();
                                                System.out.println("Ingrese Id Flujo Inicial, presione ENTER:");
                                                var vIdChatbotFlow = input.nextInt();

                                                Chatbot_Bustamante13452 vChatbot = new Chatbot_Bustamante13452(vIdChatbot, vNameChatbot, vMsgChatbot, vIdChatbotFlow, flows);
                                                chatbots.add(vChatbot);
                                                //Agregar al sistema
                                                system.systemAddChatbot(vIdChatbot, vNameChatbot, vMsgChatbot, vIdChatbotFlow, flows);
                                                System.out.println("\n Mostrando contenido variable vChatbot: ");
                                                System.out.println(vChatbot);
                                                System.out.println("\n Mostrando contenido System: ");
                                                System.out.println(system);
                                                break;

                                            case 0:
                                                System.out.println("Volviendo a menu admin");
                                                break;
                                            default:
                                                System.out.println(opChatbot + " opción no valida! Intentalo nuevamente.");
                                        }
                                    } while (opChatbot != 0);

                                    break;
                                case 2: //Modificar Chatbot.

                                    do {
                                        mostrarMenuModificarChatbot();
                                        opModChatbot = input.nextInt();

                                        switch (opModChatbot) {
                                            case 1: //agregar opcion a flujo
                                                //desplegar lista de flujos
                                                System.out.println(flows);
                                                System.out.println("Ingrese IdFlow para modificar :");
                                                var vIdFlowMod = input.nextInt();
                                                //Flow_Bustamante13452 vFlow = new Flow_Bustamante13452(vIdFlow, vMsgFlow, opcion);
                                                //flows.add(vFlow);

                                                //desplegar lista de opciones
                                                System.out.println(opcion);
                                                System.out.println("Ingrese codigo de opcion para agregar al flujo :");
                                                var vIdOpFlowMod = input.nextInt();

                                                break;

                                            case 2: //agregar flujo a chatbot
                                                //desplegar lista de flujos
                                                System.out.println("Ingrese algo y presione ENTER:");
                                                break;

                                            case 0:
                                                System.out.println("Volviendo al menu usuario");
                                                break;

                                            default:
                                                System.out.println(opModChatbot + " opción no valida! Intentalo nuevamente.");
                                        }
                                    } while (opModChatbot != 0);
                                    break;
                                case 3: //Ejecutar un Chatbot.
                                    System.out.println(" Ejecutar Chatbot.");
                                    break;
                                case 4: //Visualizar Chatbot Existentes
                                    System.out.println(" Visualizar Chatbot Existentes en el Sistema..");
                                    //buscarlos en el system

                                    break;
                                case 5: //Visualizar Chatbot con Flujos y Opciones
                                    System.out.println(" Visualizar Chatbot con Flujos y Opciones Creadas.");
                                    //buscarlos en el system
                                    break;
                                case 0:
                                    System.out.println("Cerrando sesion");
                                    break;
                                default:
                                    System.out.println(opAdmin + " opción no valida! Intentalo nuevamente.");
                            }
                        } while (opAdmin != 0);

                    } else {
                        System.out.println("Mostrar menu normal");
                    }
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
        System.out.print(" 1. Iniciar sesion Usuario. \n");
        System.out.print(" 2. Registrar Usuario.\n");
        System.out.print(" 0. Salir del Sistema\n");
        System.out.print("==================================\n");
        System.out.print("\nIngrese su opción: ");
    }

    private static void printMenuRegister() {
        System.out.print("\n=============================================\n");
        System.out.println("   Sistema de Chatbot - Registro Usuario  ");
        System.out.print("=============================================\n");
        System.out.print(" 1. Registrar usuario admin.\n");
        System.out.print(" 2. Registrar usuario normal.\n");
        System.out.print(" 3. Volver al menu usuario\n");
        System.out.print("=============================================\n");
        System.out.print("\nIngrese su opción: ");
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
        System.out.print("0. Cerrar Sesion\n");
        System.out.print("\nIngrese su opción: ");
    }

    private static void mostrarMenuChatbot() {
        System.out.print("\n=======================================================\n");
        System.out.println("  Sistema de Chatbot - Menu Crear Chatbot ");
        System.out.print("=======================================================\n");
        System.out.print("1. Crear Opcion. \n");
        System.out.print("2. Crear Flujo.\n");
        System.out.print("3. Crear Chatbot.\n");
        System.out.print("0. Volver\n");
        System.out.print("\nIngrese su opción: ");
    }

    private static void mostrarMenuModificarChatbot(){
        System.out.print("\n=======================================================\n");
        System.out.println("  Sistema de Chatbot - Menu Modificar Chatbot ");
        System.out.print("=======================================================\n");
        System.out.print("1. Agrgar Opcion a flujo. \n");//de las ya creadas
        System.out.print("2. Agregar Flujo a Chatbot.\n");
        System.out.print("0. Volver\n");
        System.out.print("\nIngrese su opción: ");
    }
  /*  private static void printMenuUser() {
        System.out.print("\n=============================================\n");
        System.out.println("   Sistema de Chatbot - Menu Usuario Normal ");
        System.out.print("=============================================\n");
        System.out.print("1. Ejecutar un Chatbot. \n");
        System.out.print("2. Visualizar Chatbots Existentes en el Sistema.\n");
        System.out.print("2. Visualizar Flows Existentes en el Sistema.\n");
        System.out.print("2. Visualizar Options Existentes en el Sistema.\n");
        System.out.print("0. Finalizar sesion\n");
        System.out.print("\nIngrese su opción: ");
    }
    */

    /* Menu tipo
    do {
        printMenuNuevo();
        opMenuNuevo = input.nextInt();

        switch (opMenuNuevo) {
            case 1: //
                System.out.println("Ingrese algo y presione ENTER:");
                break;

            case 2: //crear user normal
                System.out.println("Ingrese algo y presione ENTER:");
                break;

            case 0:
                System.out.println("Volviendo al menu usuario");
                break;

            default:
                System.out.println(opMenuNuevo + " opción no valida! Intentalo nuevamente.");
            }
        } while (opMenuNuevo != 0);

    */

}