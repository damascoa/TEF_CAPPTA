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
        TEF cappta = new Cappta("08476665000188", "51", "63I8UAWW");
        if (cappta.Autenticacao()) {
            RetornoCappta retorno = (RetornoCappta) cappta.pagarCredito(new BigDecimal("0.01"));
            if (retorno instanceof RetornoAprovado) {
                System.out.println("COMPROVANTE CLIENTE " + ((RetornoAprovado) retorno).getComprovanteClienteCompleto() + "\n\n");
                System.out.println("================================================================\n");
                System.out.println("COMPROVANTE LOJISTA " + ((RetornoAprovado) retorno).getComprovanteLojaCompleto() + "\n\n");
                System.out.println("================================================================\n");
                System.out.println("COMPROVANTE REDUZIDO " + ((RetornoAprovado) retorno).getComprovanteReduzido() + "\n\n");
            } else if (retorno instanceof RetornoPendente) {
                System.out.println("MOTIVO DA RECUSA: " + ((RetornoRecusado) retorno).getMotivo());
            } else if (retorno instanceof RetornoRecusado) {
                System.out.println("MOTIVO DA RECUSA: " + ((RetornoRecusado) retorno).getMotivo());
            }
        } else {
            return;
        }

    }
}
