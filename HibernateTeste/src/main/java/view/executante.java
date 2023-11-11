package view;

import model.Despesa;
import model.Receita;
import model.usuario;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class executante {
    public static void main(String args[]){
        Receita receita = new Receita();

        receita.setDescricao("salario");
        receita.setTipo("fixa");
        receita.setValor(100);

        Despesa despesa = new Despesa();

        //despesa.setVencimento("2023-11-30");
        despesa.setDescricao("aluguel");
        despesa.setValor(1200);
        despesa.setTipo("fixa");
        despesa.setVencimento("2023-11-20");


        //control.despesaDAO.getInstace().inserirUsuario(despesa);
        //control.receitaDAO.getInstace().inserirReceita(receita);

        Despesa gingado = control.despesaDAO.getInstace().encontraDespesaId(25);
        JOptionPane.showMessageDialog(null,gingado.getDescricao());
    }
}
