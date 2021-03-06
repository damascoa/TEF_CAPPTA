/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metre.tef;

import com.metre.cappta.RetornoCappta;
import com.metre.cappta.services.enums.TipoVia;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Renato
 */
public interface ITEF {

    //CNPJ DA EMPRESA
    //PDV = EMPRESA FORNECEDOR DO TEF DIVULGA  //CAPPTA ATE O MOMENTO
    //CHVA = EMPRESA FORNECEDOR DO TEF DIVULGA //CAPPTA ATE O MOMENTO
    public Boolean Autenticacao();

    public RetornoTEF pagarCredito(BigDecimal valor);

    public RetornoTEF pagarDebito(BigDecimal valor);

    //SENHA     =  
    //CONTROLE  =  RETORNADO NA TRANSACAO 03750801023
    //CONTROLE  =  RETORNADO NA TRANSACAO 03750801023
    //CONTROLE  =  RETORNADO NA TRANSACAO 123456
    public RetornoTEF cancelarPagamento(String senha, String numeroControle);

    public RetornoTEF reimprimirTEF(String numeroControle, TipoVia tipoVia);

}
