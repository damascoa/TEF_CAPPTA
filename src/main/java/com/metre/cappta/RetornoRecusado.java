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
public class RetornoRecusado extends RetornoCappta {

    private Integer codigo;
    private String motivo;

    public RetornoRecusado(IRespostaOperacaoRecusada resposta) {
        this.codigo = resposta.codigoMotivo();
        this.motivo = resposta.motivo();
    }

    public RetornoRecusado(Integer codigo, String motivo) {
        this.codigo = codigo;
        this.motivo = motivo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "RetornoRecusado{" + "codigo=" + codigo + ", motivo=" + motivo + '}';
    }

}
