package view;

import model.Receita;
import model.usuario;

public class executante {
    public static void main(String args[]){
        Receita receita = new Receita();

        receita.setDescricao("salario");
        receita.setTipo("fixa");
        receita.setValor(100);

        control.receitaDAO.getInstace().inserirUsuario(receita);

    }
}
