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
import java.math.BigDecimal;

/**
 *
 * @author Renato
 */
public class Cappta extends TEF {

    private String cnpj;
    private String pdv;
    private String chave;

    public Cappta(String cnpj, String pdv, String chave) {
        this.cnpj = cnpj;
        this.pdv = pdv;
        this.chave = chave;
    }

    @Override
    public Boolean Autenticacao() {
        Autenticar autenticar = new Autenticar();
        return new Autenticar().autenticar(cnpj, Integer.parseInt(pdv), chave);
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

}
