package org.example;

public class User_Bustamante13452 {
    private String userName;
    private boolean estaLogeado;
    private boolean esAdmin;


    public User_Bustamante13452(String userName, boolean esAdmin, boolean estaLogeado) {
        this.userName = userName;
        this.esAdmin = esAdmin;
        this.estaLogeado = estaLogeado;
    }

    @Override
    public String toString() {
        return "\n User_Bustamante13452{" +
                "Nombre Usuario ='" + userName + '\'' +
                ", es administrador =" + esAdmin +
                ", estaLogeado =" + estaLogeado +
                '}';
    }

    public void login(){ this.estaLogeado = true; }
    public boolean isEsAdmin() {  return esAdmin;  }
    public String getUserName() { return userName; }
    public void logout() { this.estaLogeado = false; }

}
