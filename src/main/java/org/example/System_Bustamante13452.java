package org.example;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class System_Bustamante13452 implements ISystem_Bustamante13452 {
    private String name;
    private Date fechaCreacion;
    private List<User_Bustamante13452> users = new ArrayList<>();
    private String currentUser;//para saber que usuario esta logeado
    public System_Bustamante13452(String name) {
        this.name = name;
        this.fechaCreacion = fechaCreacion;
        this.currentUser = "";
    }




    public void register(String userName, boolean esAdmin, boolean estaLogeado){
        User_Bustamante13452 user = new User_Bustamante13452(userName, esAdmin, estaLogeado);
        users.add(user);

    }

    public void login(String userName) {
        for(User_Bustamante13452 user : users){//recorre lista usuarios buscando conicidencia
            if(user.isEstaLogeado() == true) {//si lo encuentra
                if (Objects.equals(user.getUserName(), userName)) {//si lo encuentra
                    user.login();//lo logea
                }
            }
        }
    }

    @Override
    public void logout(String userName) {

    }


    @Override
    public String toString() {
        return "System_Bustamante13452{" +
                "Nombre='" + name + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", usuarios=" + users +
                ", usuario actual='" + currentUser + '\'' +
                '}';
    }
}
