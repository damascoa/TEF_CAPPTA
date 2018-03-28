/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metre.cappta.services;

import com.metre.cappta.ClassFactory;
import com.metre.cappta.IClienteCappta;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class Autenticar {

//    IClienteCappta cappta;
    public boolean autenticar(String cnpj, Integer pdv, String chave) {
        ContanteCaptta.cappta = ClassFactory.createClienteCappta();
        int resultadoAltenticacao;
        Boolean autenticado = false;
        resultadoAltenticacao = ContanteCaptta.cappta.autenticarPdv(cnpj, pdv, chave);
        switch (resultadoAltenticacao) {
            case 1:
                JOptionPane.showMessageDialog(null, "Não autorizado. Por favor, realize a autenticação para utilizar o CapptaGpPlus");
                autenticado = false;
            case 2:
                JOptionPane.showMessageDialog(null, "O CapptaGpPlus esta sendo inicializado, tente novamente em alguns instantes.");
                autenticado = false;
            case 3:
                JOptionPane.showMessageDialog(null, "O formato da requisição recebida pelo CapptaGpPlus é inválido.");
                autenticado = false;
            case 4:
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo operador.");
                autenticado = false;
            case 7:
                JOptionPane.showMessageDialog(null, "Ocorreu um erro interno no CapptaGpPlus.");
                autenticado = false;
            case 8:
                JOptionPane.showMessageDialog(null, "Ocorreu um erro na comunicação entre a CappAPI e o CapptaGpPlus.");
                autenticado = false;
            case 0:
                autenticado = true;
        }
        return autenticado;
    }

}
