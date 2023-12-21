package org.example;

import java.util.*;

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
        List<Option_Bustamante13452> opNew = new ArrayList<>();
        List<Flow_Bustamante13452> flowNew = new ArrayList<>();
        List<Chatbot_Bustamante13452> chatbotNew = new ArrayList<>();

        /* Inicio Carga de datos duros al sistema  */
        system.register("usuario01", true, false);

        //Creo Keywords
        List<String> keywordsOp1 = Arrays.asList("viajar", "pasatiempos");
        List<String> keywordsOp2 = Arrays.asList("estudiar", "postgrado");
        List<String> keywordsOp3 = Arrays.asList("New York", "Paris");
        List<String> keywordsOp4 = Arrays.asList("Central", "Museos");
        //Creo opciones
        Option_Bustamante13452 op1 = new Option_Bustamante13452(0, "Viajar", 1, 1, keywordsOp1);
        Option_Bustamante13452 op2 = new Option_Bustamante13452(1, "Estudiar", 1, 1, keywordsOp2);
        Option_Bustamante13452 op3 = new Option_Bustamante13452(2, "Donde Te gustaria Ir", 1, 2,keywordsOp3);
        Option_Bustamante13452 op4 = new Option_Bustamante13452(3, "Que atractivos te gustaria visitar", 1, 3, keywordsOp4);
        //agregar opciones a lista de opciones
        opcion.add(op1);
        opcion.add(op2);
        opcion.add(op3);
        opcion.add(op4);

        //Lista de opciones Flujo Inicial
        List<Option_Bustamante13452> opFinicial = new ArrayList<>();
        opFinicial.add(op1);
        Flow_Bustamante13452 fInicial = new Flow_Bustamante13452(0, "Flujo Inicial", opFinicial);
        fInicial.flowAddOption(op2);

        List<Option_Bustamante13452> opViajar = new ArrayList<>();
        opViajar.add(op3);

        List<Option_Bustamante13452> opLugares = new ArrayList<>();
        opLugares.add(op4);

        Flow_Bustamante13452 fViajar = new Flow_Bustamante13452(1, "Flujo Viajar", opViajar);
        Flow_Bustamante13452 fLugares = new Flow_Bustamante13452(2, "Flujo Lugares", opLugares);
        flows.add(fInicial);
        flows.add(fViajar);
        flows.add(fLugares);

        Chatbot_Bustamante13452 ChatFinicial = new Chatbot_Bustamante13452(0, "Inicial", "Bienvenido", 1, List.of(fInicial));
        Chatbot_Bustamante13452 ChatFviajar = new Chatbot_Bustamante13452(1, "Viajes", "Bienvenido a Viajar", 2, List.of(fViajar));
        Chatbot_Bustamante13452 ChatFLugares = new Chatbot_Bustamante13452(2, "Destinos", "Bienvenido a destinos", 3, List.of(fLugares));
        chatbots.add(ChatFinicial);
        chatbots.add(ChatFviajar);
        chatbots.add(ChatFLugares);
        system.systemAddChatbot(0, "Inicial", "Bienvenido", 1, List.of(fInicial));
        system.systemAddChatbot(1, "Viajes", "Bienvenido a Viajar", 2, List.of(fViajar));
        system.systemAddChatbot(2, "Destinos", "Bienvenido a destinos", 3, List.of(fLugares));

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
                                    System.out.println(" desea hacerlo? construyalo siguiendo orden del menu");

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
                                                Option_Bustamante13452 vOpcion = new Option_Bustamante13452(vCodOp, vMsgOp, vCodLinkChatbotOp,vCodLinkFlowIniOp, keywordsOpcion);
                                                opcion.add(vOpcion);
                                                opNew.add(vOpcion);
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("  Mostrando contenido de opcion creada: \n");
                                                System.out.println(opNew);
                                                break;

                                            case 2: //Crear Flujo.
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("          Creando Flujo    -    Sistema Chatbot.");
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("Ingrese IdFlow, presione ENTER:");
                                                var vIdFlow = input.nextInt();
                                                System.out.println("Ingrese mensaje Flow, presione ENTER:");
                                                var vMsgFlow = input.next();
                                                Flow_Bustamante13452 vFlow = new Flow_Bustamante13452(vIdFlow, vMsgFlow, opNew);
                                                flowNew.add(vFlow);
                                                flows.add(vFlow);
                                                System.out.print("\n=======================================================\n");
                                                System.out.println("Mostrando contenido de flujo creado mas opcion: \n");
                                                System.out.println(flowNew);
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
                                                Chatbot_Bustamante13452 vChatbot = new Chatbot_Bustamante13452(vIdChatbot, vNameChatbot, vMsgChatbot, vIdChatbotFlow, flowNew);
                                                chatbots.add(vChatbot);
                                                chatbotNew.add(vChatbot);
                                                //Agregar al sistema
                                                system.systemAddChatbot(vIdChatbot, vNameChatbot, vMsgChatbot, vIdChatbotFlow, flowNew);
                                                System.out.println("\n Mostrando chatbot creado: ");
                                                System.out.println(chatbotNew);
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
                                                //desplegar lista de opciones
                                                System.out.println(opcion);
                                                System.out.println("\n Ingrese codigo de opcion para agregar al flujo :");
                                                var vIdOpbuscado = input.nextInt();
                                                //buscar opcion deseada
                                                Option_Bustamante13452 opBuscada = null;
                                                for (Option_Bustamante13452 elemento : opcion) {
                                                    if (elemento.getCode() == vIdOpbuscado) {
                                                        String msg = elemento.getMessage();
                                                        int codeLinkChatbot = elemento.getChatbotCodeLink();
                                                        int codeLinkFlow = elemento.getInitialFlowCodeLink();
                                                        List<String> keywordsBuscada = elemento.getKeywords();
                                                        opBuscada = new Option_Bustamante13452(vIdOpbuscado, msg, codeLinkChatbot, codeLinkFlow, keywordsBuscada);
                                                        break;// sale cuando la encuentra
                                                    }
                                                }
                                                if (opBuscada != null) {
                                                    // Verificar si la opción ya existe en la lista 'opcion'
                                                    if (!opcion.contains(opBuscada)) {
                                                        opcion.add(opBuscada);
                                                    }
                                                    //desplegar lista de flujos
                                                    System.out.println(flows);
                                                    System.out.println("\n Ingrese IdFlow de a modificar :");
                                                    var vIdFlowMod = input.nextInt();
                                                    //buscar flujo deseado
                                                    Flow_Bustamante13452 flowBuscado = null;
                                                    for (Flow_Bustamante13452 eleFlow : flows) {
                                                        if (eleFlow.getId() == vIdFlowMod) {
                                                            String msgF = eleFlow.getName_Msg();
                                                            List<Option_Bustamante13452> opFlows = eleFlow.getOptions();
                                                            flowBuscado = new Flow_Bustamante13452(vIdFlowMod, msgF, opFlows);
                                                            break;
                                                        }
                                                    }
                                                    if (flowBuscado != null) {
                                                        // Verificar si la opción no está ya en el flujo
                                                        if (!flowBuscado.getOptions().contains(opBuscada)) {
                                                            flowBuscado.flowAddOption(opBuscada);
                                                            System.out.println("Opción agregada al flujo.");
                                                            System.out.println(flows);
                                                        }
                                                    } else {
                                                        System.out.println("Flujo con ID " + vIdFlowMod + " no encontrado.");
                                                    }
                                                } else {
                                                    System.out.println("Opción no encontrada.");
                                                }
                                                break;

                                            case 2: //agregar flujo a chatbot
                                                //desplegar lista de flujos
                                                System.out.println(flows);
                                                System.out.println("\n Ingrese codigo flujo para agregar al chatbot :");
                                                var vIdFlowB = input.nextInt();
                                                //buscar flujo deseado
                                                Flow_Bustamante13452 flowBuscado2 = null;
                                                for (Flow_Bustamante13452 eleFlow : flows) {
                                                    if (eleFlow.getId() == vIdFlowB) {
                                                        String msgF = eleFlow.getName_Msg();
                                                        List<Option_Bustamante13452> opFlows = eleFlow.getOptions();
                                                        flowBuscado2 = new Flow_Bustamante13452(vIdFlowB, msgF, opFlows);
                                                        break;//sale cuando la encuentra
                                                    }
                                                }
                                                if (flowBuscado2 != null) {
                                                    // Verificar si el flujo no está ya en el chatbot
                                                    if (!flows.contains(flowBuscado2)) {
                                                        flows.add(flowBuscado2);
                                                    }

                                                    //desplegar lista de chatbot
                                                    System.out.println(chatbots);
                                                    System.out.println("\n Ingrese IdChatbot a modificar :");
                                                    var vIdChatbotMod = input.nextInt();
                                                    //buscar chatbot deseado
                                                    Chatbot_Bustamante13452 chatbotBuscado = null;
                                                    for (Chatbot_Bustamante13452 eleChat : chatbots) {
                                                        if (eleChat.getChatbotId() == vIdChatbotMod) {
                                                            String nameCb = eleChat.getName();
                                                            String msgCb = eleChat.getWelcomeMsg();
                                                            int startFlowId = eleChat.getStartFlowId();
                                                            List<Flow_Bustamante13452> flowsCb = eleChat.getFlows();
                                                            chatbotBuscado = new Chatbot_Bustamante13452(vIdChatbotMod, nameCb, msgCb, startFlowId, flowsCb);
                                                            break;
                                                        }
                                                    }

                                                    if (chatbotBuscado != null) {
                                                        // Verificar si el flujo no está ya en el chatbot
                                                        if (!chatbotBuscado.getFlows().contains(flowBuscado2)) {
                                                            chatbotBuscado.chatbotAddFlow(flowBuscado2);
                                                            System.out.println("Flujo agregado al Chatbot.");
                                                            System.out.println(chatbots);
                                                        } else {
                                                            System.out.println("Chatbot con ID " + vIdChatbotMod + " no encontrado.");
                                                        }
                                                    } else{
                                                        System.out.println("Flujo no encontrado.");
                                                    }
                                                }

                                                break;

                                            case 0:
                                                System.out.println("Volviendo al menu usuario");
                                                break;

                                            default:
                                                System.out.println(opModChatbot + " opción no valida! Intentalo nuevamente.");
                                            }
                                        } while (opModChatbot != 0);
                                        break;
                                case 3: //Ejecutar Chatbot
                                    System.out.print("\n============================================================\n");
                                    System.out.println(" Sistema de Chatbot - Ejecutar Chatbot ");
                                    System.out.print("============================================================\n");

                                    System.out.println("Bienvenido al chatbot. Escribe 'salir' para terminar conversacion\n");
                                    System.out.println("Que deseas hacer?:");
                                    System.out.println("1) Viajar");
                                    System.out.println("2) Estudiar");
                                    system.talk(flows, opcion);
                                    System.out.println("terminando conversacion.\n");
                                    break;


                                case 4: //Visualizar Chatbot Existentes
                                    System.out.print("\n============================================================\n");
                                    System.out.println(" Sistema de Chatbot - Visualizando Chatbot Existentes ");
                                    System.out.print("============================================================\n");
                                    System.out.println(chatbots);
                                    break;

                                case 5: //Visualizar Flujos y Opciones
                                    System.out.print("\n=====================================================================\n");
                                    System.out.println(" Sistema de Chatbot - Visualizando Flujos y Opciones Existentes ");
                                    System.out.print("======================================================================\n");
                                    System.out.println(flows);
                                    System.out.println(opcion);
                                    break;
                                case 0:
                                    System.out.println("Cerrando sesion");
                                    system.logout(nUserLogin); //va a system a buscar usuario en lista

                                    break;
                                default:
                                    System.out.println(opAdmin + " opción no valida! Intentalo nuevamente.");
                            }
                        } while (opAdmin != 0);
                        break;
                    } else {

                        do {
                            printMenuUser();
                            opUser = input.nextInt();

                            switch (opUser) {
                                case 1: //
                                    System.out.print("\n============================================================\n");
                                    System.out.println(" Sistema de Chatbot - Visualizando Chatbots Existentes ");
                                    System.out.print("============================================================\n");
                                    System.out.print(chatbots);
                                    break;

                                case 2: //
                                    System.out.print("\n============================================================\n");
                                    System.out.println(" Sistema de Chatbot - Visualizando Flujos Existentes ");
                                    System.out.print("============================================================\n");
                                    System.out.print(flows);
                                    break;
                                case 3: //
                                    System.out.print("\n============================================================\n");
                                    System.out.println(" Sistema de Chatbot - Visualizando Opciones Existentes ");
                                    System.out.print("============================================================\n");
                                    System.out.print(opcion);
                                    break;

                                case 0:
                                    System.out.println("Cerrando sesion");
                                    system.logout(nUserLogin); //va a system a buscar usuario en lista
                                    break;

                                default:
                                    System.out.println(opUser + " opción no valida! Intentalo nuevamente.");
                            }
                        } while (opUser != 0);

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
                            case 0:
                                System.out.println("Volviendo al menu usuario");
                                break;
                            default:
                                System.out.println(opRegister + " opción no valida! Intentalo nuevamente.");
                        }
                    } while (opRegister != 0);
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

    private static void printMenuUser() {
        System.out.print("\n=============================================\n");
        System.out.println("   Sistema de Chatbot - Menu Usuario Normal ");
        System.out.print("=============================================\n");
        System.out.print("1. Visualizar Chatbots Existentes en el Sistema.\n");
        System.out.print("2. Visualizar Flows Existentes en el Sistema.\n");
        System.out.print("3. Visualizar Options Existentes en el Sistema.\n");
        System.out.print("0. Finalizar sesion\n");
        System.out.print("\nIngrese su opción: ");
    }

}