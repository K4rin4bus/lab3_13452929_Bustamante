package org.example;

public class User_Bustamante13452 {
    private String userName;
    private boolean esAdmin;
    private boolean estaLogeado;



    public User_Bustamante13452(String userName, boolean esAdmin, boolean estaLogeado) {
        this.userName = userName;
        this.esAdmin = esAdmin;
        this.estaLogeado = estaLogeado;
    }

    @Override
    public String toString() {
        return "User_Bustamante13452{" +
                "Nombre Usuario ='" + userName + '\'' +
                ", es administrador =" + esAdmin +
                ", estaLogeado =" + estaLogeado +
                '}';
    }

    public void login(){ this.estaLogeado = true; }

    public void logout() { this.estaLogeado = false; }

    public boolean isEstaLogeado() {
        return estaLogeado;
    }
    public String getUserName() { return userName; }
    public boolean isEsAdmin() {  return esAdmin;  }

}
