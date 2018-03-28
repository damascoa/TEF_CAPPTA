package com.metre.app;

import com.metre.cappta.RetornoAprovado;
import com.metre.cappta.RetornoCappta;
import com.metre.cappta.RetornoPendente;
import com.metre.cappta.RetornoRecusado;
import com.metre.tef.Cappta;
import com.metre.tef.RetornoTEF;
import com.metre.tef.TEF;
import java.math.BigDecimal;

public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String canpj = "08476665000188";    // CNPJ DA EMPRESA
        String pdv = "51";                  // Nº do PDV FORNECIDO PELA CAPPTA
        String chave = "12312312312312";          // SENHA FORNECIDA PELA CAPPTA
        TEF cappta = new Cappta(canpj, pdv, chave);
        cappta.Autenticacao();
        RetornoCappta retorno = (RetornoCappta) cappta.pagarCredito(new BigDecimal("0.01"));
        if (retorno instanceof RetornoAprovado) {
            System.out.println("COMPROVANTE CLIENTE " + ((RetornoAprovado) retorno).getComprovanteClienteCompleto() + "\n\n");
            System.out.println("================================================================\n");
            System.out.println("COMPROVANTE LOJISTA " + ((RetornoAprovado) retorno).getComprovanteLojaCompleto() + "\n\n");
            System.out.println("================================================================\n");
            System.out.println("COMPROVANTE REDUZIDO " + ((RetornoAprovado) retorno).getComprovanteReduzido() + "\n\n");
        } else if (retorno instanceof RetornoPendente) {

        } else if (retorno instanceof RetornoRecusado) {
            System.out.println("MOTIVO DA RECUSA: "+((RetornoRecusado) retorno).getMotivo());
        }
    }
}
