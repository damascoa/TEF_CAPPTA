/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metre.cappta;

/**
 *
 * @author Renato
 */
public class RetornoPendente extends RetornoCappta {

    private String motivo;

    public RetornoPendente(IRespostaTransacaoPendente motivo) {
        this.motivo = motivo.mensagem();
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "RetornoPendente{" + "motivo=" + motivo + '}';
    }

}
