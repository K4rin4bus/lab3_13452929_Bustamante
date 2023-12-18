package org.example;

import java.util.List;

public class Flow_Bustamante13452 {
    private int id;
    private String name_Msg;
    private List<Option_Bustamante13452> options;

    //Constructor de flow
    public Flow_Bustamante13452(int id, String name_Msg, List<Option_Bustamante13452> options) {
        this.id = id;
        this.name_Msg = name_Msg;
        this.options = options;
    }

    //Agregar opcion al flow
    public void flowAddOption(Option_Bustamante13452 op){
        //validar opcion unica (con for)
        this.options.add(op);
    }

    @Override
    public String toString() {
        return "Flow{" +
                "id=" + id +
                ", name_Msg='" + name_Msg + '\'' +
                ", options=" + options +
                '}';
    }
}
