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
import com.metre.cappta.services.enums.TipoVia;

/**
 *
 * @author Renato
 */
public class Reimpressao {

    public String numeroControle;

    public TipoVia tipoVia;

    public Reimpressao(String numeroControle, TipoVia tipoVia) {
        this.numeroControle = numeroControle;
        this.tipoVia = tipoVia;
    }

    public RetornoCappta reimprimir() {
        RetornoCappta retorno = null;
        int resultado;
        if (numeroControle == null) {
            resultado = ContanteCaptta.cappta.reimprimirUltimoCupom(this.tipoVia.getCodigo());
        } else {
            resultado = ContanteCaptta.cappta.reimprimirCupom(numeroControle, this.tipoVia.getCodigo());
        }

        if (resultado != 0) {
            return new RetornoRecusado(resultado, new TratarErros(resultado).getMensagem());
        }

        IIteracaoTef iteracaoTef = null;

        do {
            iteracaoTef = ContanteCaptta.cappta.iterarOperacaoTef();
            if (iteracaoTef.is(IMensagem.class)) {
                IMensagem iMensagem = iteracaoTef.queryInterface(IMensagem.class);
                System.out.println(iMensagem.descricao());
            }

            if (iteracaoTef.is(IRequisicaoParametro.class)) {
                IRequisicaoParametro iRequisicaoParametro = iteracaoTef.queryInterface(IRequisicaoParametro.class);
                System.out.println("M2 " + iRequisicaoParametro.mensagem());
            }

            if (iteracaoTef.is(IRespostaTransacaoPendente.class)) {
                IRespostaTransacaoPendente resposta = iteracaoTef.queryInterface(IRespostaTransacaoPendente.class);
                return new RetornoPendente(resposta);
            }
            if (iteracaoTef.is(IRespostaOperacaoRecusada.class)) {
                IRespostaOperacaoRecusada resposta = iteracaoTef.queryInterface(IRespostaOperacaoRecusada.class);
                return new RetornoRecusado(resposta);
            }
            if (iteracaoTef.is(IRespostaOperacaoAprovada.class)) {
                IRespostaOperacaoAprovada resposta = iteracaoTef.queryInterface(IRespostaOperacaoAprovada.class);
                System.out.println("DATA DA AUTORIZACAO: " + resposta.dataHoraAutorizacao());
                System.out.println("CONTROLE           : " + resposta.numeroControle());
                System.out.println("AUTORIZACAO           : " + resposta.codigoAutorizacaoAdquirente());
                return new RetornoAprovado(resposta);
//                FinalizarPagamento();
            }

        } while (OperacaoNaoFinalizada(iteracaoTef));
        return retorno;
    }

    private boolean OperacaoNaoFinalizada(IIteracaoTef iteracaoTef) {
        return iteracaoTef.tipoIteracao() != 1 && iteracaoTef.tipoIteracao() != 2;
    }

}
