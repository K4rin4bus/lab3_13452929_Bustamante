package org.example;

public class Option {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private list<String> Keyword; //lista


    public Option(int code, String message, int chatbotCodeLink, int initialFlowCodeLink, list<String> keyword) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        Keyword = keyword;
    }
}
