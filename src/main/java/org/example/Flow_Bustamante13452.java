package org.example;

import java.util.List;
import java.util.Objects;

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
        boolean optionExiste = false;
        this.options.add(op);
    }
    public void setOptions(List<Option_Bustamante13452> options) {
        this.options = options;
    }
    @Override
    public String toString() {
        return "\n Flow{" +
                "id=" + id +
                ", name_Msg='" + name_Msg + '\'' +
                ", options=" + options +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_Msg() {
        return name_Msg;
    }

    public void setName_Msg(String name_Msg) {
        this.name_Msg = name_Msg;
    }

    public List<Option_Bustamante13452> getOptions() {
        return options;
    }

}
