/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metre.tef;

import com.metre.cappta.services.enums.TipoVia;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Renato
 */
public class TEF implements ITEF {

    @Override
    public Boolean Autenticacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RetornoTEF pagarCredito(BigDecimal valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RetornoTEF pagarDebito(BigDecimal valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RetornoTEF cancelarPagamento(String senha, String numeroControle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public RetornoTEF  reimprimirTEF(String numeroControle, TipoVia tipoVia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
