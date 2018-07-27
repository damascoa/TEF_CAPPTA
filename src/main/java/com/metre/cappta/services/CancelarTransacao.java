/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metre.cappta.services;

import com.metre.cappta.IIteracaoTef;
import com.metre.cappta.IMensagem;
import com.metre.cappta.IRequisicaoParametro;
import com.metre.cappta.IRespostaOperacaoAprovada;
import com.metre.cappta.IRespostaOperacaoRecusada;
import com.metre.cappta.IRespostaTransacaoPendente;
import com.metre.cappta.RetornoAprovado;
import com.metre.cappta.RetornoCappta;
import com.metre.cappta.RetornoPendente;
import com.metre.cappta.RetornoRecusado;
import com.metre.cappta.TratarErros;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class CancelarTransacao {

    public String senhaAdministrativa;
    public String numeroControle;

    public CancelarTransacao(String senhaAdministrativa, String numeroControle) {
        this.senhaAdministrativa = senhaAdministrativa;
        this.numeroControle = numeroControle;
    }

    public RetornoCappta cancelar() {
        RetornoCappta retorno = null;
        int resultado = ContanteCaptta.cappta.cancelarPagamento(senhaAdministrativa, numeroControle);
        if (resultado != 0) {
            return new RetornoRecusado(resultado, new TratarErros(resultado).getMensagem());
        }

        IIteracaoTef iteracaoTef = null;
        do {
            iteracaoTef = ContanteCaptta.cappta.iterarOperacaoTef();

            if (iteracaoTef.is(IMensagem.class)) {
                IMensagem iMensagem = iteracaoTef.queryInterface(IMensagem.class);
//                JOptionPane.showMessageDialog(null, iMensagem.descricao());

                System.out.println("M1 " + iMensagem.descricao());
            }

            if (iteracaoTef.is(IRequisicaoParametro.class)) {
                IRequisicaoParametro iRequisicaoParametro = iteracaoTef.queryInterface(IRequisicaoParametro.class);
//                JOptionPane.showMessageDialog(null, );
                System.out.println("M2 " + iRequisicaoParametro.mensagem());
            }

            if (iteracaoTef.is(IRespostaTransacaoPendente.class)) {
                IRespostaTransacaoPendente resposta = iteracaoTef.queryInterface(IRespostaTransacaoPendente.class);
                System.out.println("MENSAGEM: " + resposta.mensagem());
                return new RetornoPendente(resposta);
            }
            if (iteracaoTef.is(IRespostaOperacaoRecusada.class)) {
                IRespostaOperacaoRecusada resposta = iteracaoTef.queryInterface(IRespostaOperacaoRecusada.class);
                System.out.println("MENSAGEM: " + resposta.motivo());
                return new RetornoRecusado(resposta);
            }
            if (iteracaoTef.is(IRespostaOperacaoAprovada.class)) {
                IRespostaOperacaoAprovada resposta = iteracaoTef.queryInterface(IRespostaOperacaoAprovada.class);
                System.out.println("DATA AUTORIZACAO CANCELAMENTO : "+resposta.dataHoraAutorizacao());
                ContanteCaptta.cappta.confirmarPagamentos();
                return new RetornoAprovado(resposta);

            }

        } while (OperacaoNaoFinalizada(iteracaoTef));
        return retorno;
    }

//    public void finalizarPagamento() {
//        int dialogButton = JOptionPane.YES_NO_OPTION;
//        int dialogResult = JOptionPane.showConfirmDialog(null, "Confirma o recebimento?", "", dialogButton);
//        if (dialogResult == JOptionPane.YES_OPTION) {
//            ContanteCaptta.cappta.confirmarPagamentos();
//        } else {
//            ContanteCaptta.cappta.desfazerPagamentos();
//        }
//    }
    private boolean OperacaoNaoFinalizada(IIteracaoTef iteracaoTef) {
        return iteracaoTef.tipoIteracao() != 1 && iteracaoTef.tipoIteracao() != 2;
    }

}
