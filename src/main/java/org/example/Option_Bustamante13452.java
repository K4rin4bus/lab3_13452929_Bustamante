package org.example;
import java.util.List;

public class Option_Bustamante13452 {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> Keywords; //lista palabras claves

    //Constructor Option
    public Option_Bustamante13452(int code, String message, int chatbotCodeLink, int initialFlowCodeLink, List<String> keyword) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.Keywords = keyword;
    }

    @Override
    public String toString() {
        return "Option{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", chatbotCodeLink=" + chatbotCodeLink +
                ", initialFlowCodeLink=" + initialFlowCodeLink +
                ", Keyword=" + Keywords +
                '}';
    }
}
