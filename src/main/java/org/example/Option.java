package org.example;

import java.util.List;

public class Option {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> Keyword; //lista


    public Option(int code, String message, int chatbotCodeLink, int initialFlowCodeLink, List<String> keyword) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.Keyword = keyword;
    }
}
