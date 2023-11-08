package view;

import model.usuario;

public class executante {
    public static void main(String args[]){
        usuario instanciado = new usuario();

        instanciado.setName("Arthur Biogenes");

        control.userDAO.getInstace().inserirUsuario(instanciado);
    }
}
