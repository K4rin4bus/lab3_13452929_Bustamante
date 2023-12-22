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
   // private List<History_Bustamante13452> history = new ArrayList<>();

    public System_Bustamante13452(String name) {
        this.name = name;
        this.fechaCreacion = new Date();
        this.currentUser = "";
    }

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

    @Override
    public void logout(String userName) {
        for(User_Bustamante13452 user : users){//recorre lista usuarios buscando conicidencia
            if(Objects.equals(user.getUserName(), userName)){//si lo encuentra
                user.logout();//lo deslogea
            }
        }
    }

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

    public String talk(List<Flow_Bustamante13452> flows){

        Scanner inputTalk = new Scanner(System.in);
        List<Flow_Bustamante13452> flowsTalk = flows;

        while (true) {
            System.out.print("Usuario: ");
            String userInput = inputTalk.nextLine();

            if (userInput.equalsIgnoreCase("salir")) {
                System.out.println("¡Hasta luego!");
                break;
            }

            Flow_Bustamante13452 matchingFlow = buscarFlujoPorOpcion(userInput, flowsTalk);

            System.out.println(matchingFlow);
            if (matchingFlow != null) {
                System.out.println("Chatbot: " + matchingFlow.getName_Msg());
                String match = matchingFlow.getName_Msg();
                // realizar acciones según el flujo encontrado.
                mostrarFlujoFinder(matchingFlow);

            } else {
                System.out.println("Chatbot: No se encontró una opción correspondiente.");
                // Puedes manejar este caso según tus necesidades.
            }
        }

        // Por ahora, devuelve una respuesta, quizas aqui podria ir creando el history
        return "¡Hola! Soy un chatbot y estoy procesando tu mensaje";

    }

    private static Flow_Bustamante13452 buscarFlujoPorOpcion(String userInput, List<Flow_Bustamante13452> flowsTalk){
        // Itera sobre la lista de flujos y busca una opción que coincida con el input del usuario.
        for (Flow_Bustamante13452 flowTalk : flowsTalk){
            for(Option_Bustamante13452 optionTalk : flowTalk.getOptions()){
                for (String keyword : optionTalk.getKeywords()) {
                    if (userInput.toLowerCase().contains(keyword.toLowerCase())) {
                        return flowTalk; // Devuelve el flujo si se encuentra una coincidencia.
                    }
                }
            }
        }
        return null; //Devuelve null si no se encuentra ninguna coincidencia.
    }


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
