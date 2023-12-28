package org.example;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner; //estoy probando

public class System_Bustamante13452 implements ISystem_Bustamante13452 {
    private String name;
    private Date fechaCreacion;
    private List<User_Bustamante13452> users = new ArrayList<>();
    private String currentUser;//para saber que usuario esta logeado
    private List<Chatbot_Bustamante13452> chatbots = new ArrayList<>();
    private List<String> chatHistory = new ArrayList<>();

    /**
     * Constructor de System
     */
    public System_Bustamante13452(String name) {
        this.name = name;
        this.fechaCreacion = new Date();
        this.currentUser = "";
    }

    /**
     * metodo para crear usuario
     */
    public void register(String userName, boolean esAdmin, boolean estaLogeado) {
        boolean usuarioExistente = false;

        for (User_Bustamante13452 user : users) {//recorre lista usuarios buscando conicidencia
            if (Objects.equals(user.getUserName(), userName)) {//si lo encuentra
                System.out.println("usuario ya existe, no puede crearse nuevamente\n\n");
                usuarioExistente = true;
                break;
            }
        }

        if (!usuarioExistente) {
            //usuario no existe, se crea
            User_Bustamante13452 user = new User_Bustamante13452(userName, esAdmin, estaLogeado);
            users.add(user);
            System.out.println("usuario creado satisfactoriamente\n\n");
        }
    }
    /**
     * metodo para iniciar sesion usuario
     */
    public boolean login(String userName) {
        boolean userLogExist = false;
        boolean isAdminLoggerIn = false;

        for (User_Bustamante13452 user : users) {//recorre lista usuarios buscando conicidencia
            if (Objects.equals(user.getUserName(), userName)) {//si lo encuentra
                user.login();//lo logea
                userLogExist = true;
                isAdminLoggerIn = user.isEsAdmin();// asigna tipo de usuario
                System.out.println(isAdminLoggerIn);
                // return user.isEsAdmin();
                break;
            }
        }

        if (!userLogExist) {//usuario no existe
            System.out.println("usuario no existe, debe registrarse para iniciar sesion\n\n");
        }
        return isAdminLoggerIn;
    }
    /**
     * metodo para cerrar sesion usuario
     */
    @Override
    public void logout(String userName) {
        for(User_Bustamante13452 user : users){//recorre lista usuarios buscando conicidencia
            if(Objects.equals(user.getUserName(), userName)){//si lo encuentra
                user.logout();//lo deslogea
            }
        }
    }

    /**
     * metodo para agregar un chatbot al sistema
     */
    public void systemAddChatbot(int idChatbot, String nameChatbot, String msgChatbot, int idChatbotFlow, List<Flow_Bustamante13452> flows){
        boolean chatbotExiste = false;

        for (Chatbot_Bustamante13452 id : chatbots) {//recorre lista chatbot buscando conicidencia
            if (Objects.equals(id.getChatbotId(), id)) {//si lo encuentra
                System.out.println("Chatbot ya existe, no puede agregarse\n\n");
                chatbotExiste = true;
                break;
            }
        }
        if (!chatbotExiste) {
            //chatbot no existe, se crea
            Chatbot_Bustamante13452 chatbot = new Chatbot_Bustamante13452(idChatbot, nameChatbot, msgChatbot, idChatbotFlow, flows);
            chatbots.add(chatbot);
        }
    }

    /**
     * metodo para interactuar con el chatbot
     */
    public String talk(List<Flow_Bustamante13452> flows, List<Option_Bustamante13452> options){

        Scanner inputTalk = new Scanner(System.in);
        List<Chatbot_Bustamante13452> chatbotsTalk = chatbots;

        while (true) {
            System.out.print("Usuario: ");
            String userInput = inputTalk.nextLine();
            Option_Bustamante13452 matchingOption = buscarOtionPorKeyword(userInput, chatbotsTalk);

            if (userInput.equalsIgnoreCase("salir")) {
                System.out.println("¡Hasta luego!");
                break;
            }
            if (matchingOption != null) {
                int matchIniFlowCodeLink = matchingOption.getInitialFlowCodeLink();
                int matchCbCodeLink = matchingOption.getChatbotCodeLink();
                //buscar chatbot y flows
                Flow_Bustamante13452 matchingFlow = buscarCbPorCodeLink(chatbotsTalk, matchCbCodeLink, matchIniFlowCodeLink);
                if (matchingFlow != null) {
                    mostrarFlujoFinder(matchingFlow);
                }else {
                    System.out.println("Chatbot: No se encontró un flujo correspondiente.");
                    System.out.println("Chatbot: 'salir' para volver al menu y crear flujo.");
                }

            } else {
                System.out.println("Chatbot: No se encontró una opción correspondiente.");
                System.out.println("Chatbot: 'salir' para volver al menu y crear opcion.");
            }
        }
        // Quizas aqui podria ir creando el history
        return "¡Hola! Soy un chatbot y estoy procesando tu mensaje";
    }
    /**
     * metodo para mostrar flujo encontrado
     */
    private static Option_Bustamante13452 buscarOtionPorKeyword(String userInput, List<Chatbot_Bustamante13452> cbsTalk){
        for (Chatbot_Bustamante13452 chatbot : cbsTalk) {
            for (Flow_Bustamante13452 flow : chatbot.getFlows()) {
                for (Option_Bustamante13452 option : flow.getOptions()) {
                    for (String keyword : option.getKeywords()) {
                        if (userInput.equalsIgnoreCase(keyword)) {
                            return option;
                        }
                    }
                }
            }
        }
        return null;
    }
    /**
     * metodo para buscar un flujo dentro de un chatbot
     * devuelve un flow
     */
    private static Flow_Bustamante13452 buscarCbPorCodeLink(List<Chatbot_Bustamante13452> cbsTalk, int matchCbCodeLink, int matchIniFlowCodeLink) {
    for (Chatbot_Bustamante13452 chatbot : cbsTalk) {
        if (matchCbCodeLink == chatbot.getChatbotId()) {
            for (Flow_Bustamante13452 flow : chatbot.getFlows()) {
                if (matchIniFlowCodeLink == flow.getId()) {
                    return flow;
                }
            }
        }
    }
    return null;
}
    /**
     * metodo para mostrar flujo encontrado
     */
    private static void mostrarFlujoFinder(Flow_Bustamante13452 flowEncontrado){
        String msgFinder = flowEncontrado.getName_Msg();
        List<Option_Bustamante13452> opFinder = new ArrayList<>();
        opFinder = flowEncontrado.getOptions();
        System.out.print("\n==================================\n");
        System.out.println(msgFinder);
        System.out.print("==================================\n");
        for(Option_Bustamante13452 op : opFinder){
            String msgOpFinder = op.getMessage();
            System.out.print(msgOpFinder);
            System.out.print("\n");
        }
        System.out.print("==================================\n");
    }

    @Override
    public String toString() {
        return "\n System_Bustamante13452{" +
                "Nombre sistema='" + name + '\'' +
                ", Fecha Creacion=" + fechaCreacion +
                ", Usuarios=" + users +
                ", currentUser='" + currentUser + '\'' +
                ", Chatbots=" + chatbots +
                '}';
    }

}
