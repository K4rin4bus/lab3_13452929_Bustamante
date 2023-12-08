package org.example;

import java.util.List;

public class Flow {
    private int id;
    private String name_Msg;
    private List<Option> options;


    public Flow(int id, String name_Msg, List<Option> options) {
        this.id = id;
        this.name_Msg = name_Msg;
        this.options = options;
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

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    //Agregar opcion
    public void flowAddOption(Option op){
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
