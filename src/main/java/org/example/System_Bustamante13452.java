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
