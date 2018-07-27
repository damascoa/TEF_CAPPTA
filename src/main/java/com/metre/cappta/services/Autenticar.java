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
        System.out.println("AUTENTICANDO O TEF!!!");
        ContanteCaptta.cappta = ClassFactory.createClienteCappta();
        int resultadoAltenticacao;
        Boolean autenticado = false;
        resultadoAltenticacao = ContanteCaptta.cappta.autenticarPdv(cnpj, pdv, chave);
        System.out.println("RESULTADO =========================" + resultadoAltenticacao);
        switch (resultadoAltenticacao) {
            case 1:
                JOptionPane.showMessageDialog(null, "Não autorizado. Por favor, realize a autenticação para utilizar o CapptaGpPlus");
                autenticado = false;
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "O CapptaGpPlus esta sendo inicializado, tente novamente em alguns instantes.\n"
                        + "Feche o sistema e abra-o quanto o CapptaGpPlus estiver executando!");
                autenticado = false;
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "O formato da requisição recebida pelo CapptaGpPlus é inválido.");
                autenticado = false;
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo operador.");
                autenticado = false;
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Ocorreu um erro interno no CapptaGpPlus.");
                autenticado = false;
                break;
            case 8:
                JOptionPane.showMessageDialog(null, "Ocorreu um erro na comunicação entre a CappAPI e o CapptaGpPlus.");
                autenticado = false;
                break;
            case 0:
                autenticado = true;
                break;
        }
        return autenticado;
    }

}
