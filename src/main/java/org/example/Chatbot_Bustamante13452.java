package org.example;

import java.util.List;

public class Chatbot_Bustamante13452 {
    private int chatbotId;
    private String name;
    private String welcomeMsg;
    private int startFlowId;
    private List<Flow_Bustamante13452> flows;

    //Constructor de chatbot
    public Chatbot_Bustamante13452(int chatbotId, String name, String welcomeMsg, int startFlowId, List<Flow_Bustamante13452> flows) {
        this.chatbotId = chatbotId;
        this.name = name;
        this.welcomeMsg = welcomeMsg;
        this.startFlowId = startFlowId;
        this.flows = flows;
    }



    //Agregar opcion al flow
    public void chatbotAddFlow(Flow_Bustamante13452 flow){
        //validar opcion unica (con for)
        this.flows.add(flow);
    }


    @Override
    public String toString() {
        return "\n Chatbot_Bustamante13452{" +
                "chatbotId=" + chatbotId +
                ", name='" + name + '\'' +
                ", welcomeMsg='" + welcomeMsg + '\'' +
                ", startFlowId=" + startFlowId +
                ", flows=" + flows +
                '}';
    }

    public int getChatbotId() {
        return chatbotId;
    }

    public String getName() {
        return name;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public int getStartFlowId() {
        return startFlowId;
    }

    public List<Flow_Bustamante13452> getFlows() {
        return flows;
    }
}
