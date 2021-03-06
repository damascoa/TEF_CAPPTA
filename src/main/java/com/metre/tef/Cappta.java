/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metre.tef;

import com.metre.cappta.IClienteCappta;
import com.metre.cappta.RetornoCappta;
import com.metre.cappta.services.Autenticar;
import com.metre.cappta.services.CancelarTransacao;
import com.metre.cappta.services.RecebeCredito;
import com.metre.cappta.services.RecebeDebitoVoucher;
import com.metre.cappta.services.Reimpressao;
import com.metre.cappta.services.enums.TipoVia;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renato
 */
public class Cappta extends TEF {

    private String cnpj;
    private String pdv;
    private String chave;

    public Cappta(String cnpj, String pdv, String chave) {
        System.out.println(System.getProperty("sun.arch.data.model"));
        if (!System.getProperty("sun.arch.data.model").equals("32")) {
            throw new RuntimeException("Versão do JAVA não suportada! Utiliza uma versão 32 Bits.");
        }
        this.cnpj = cnpj;
        this.pdv = pdv;
        this.chave = chave;
    }

    @Override
    public Boolean Autenticacao() {
        Autenticar autenticar = new Autenticar();
        Boolean bol = new Autenticar().autenticar(cnpj, Integer.parseInt(pdv), chave);
        System.out.println("FOI BOL" + bol);

        if (bol) {
            return true;
        } else {
            throw new RuntimeException("Não foi possível autenticar com o Cappta!");
        }
    }

    @Override
    public RetornoCappta pagarCredito(BigDecimal valor) {
        return new RecebeCredito(valor).receberCredito();
    }

    @Override
    public RetornoCappta pagarDebito(BigDecimal valor) {
        return new RecebeDebitoVoucher(valor).receberCredito();
    }

    @Override
    public RetornoCappta cancelarPagamento(String senha, String numeroControle) {
        return new CancelarTransacao(senha, numeroControle).cancelar();
    }

    @Override
    public RetornoCappta reimprimirTEF(String numeroControle, TipoVia tipoVia) {
        return new Reimpressao(numeroControle, tipoVia).reimprimir();
    }

}
