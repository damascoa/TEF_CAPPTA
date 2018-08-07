/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metre.cappta;

import java.util.Date;

/**
 *
 * @author Renato
 */
public class RetornoAprovado extends RetornoCappta {

    private Date dataAutorizacao;
    private String numAutorizacao;
    private Integer idBandeiraCartao;
    private String bandeira;
    private String numeroCartao;
    private String nsu;
    private String adiquirente;
    private String numeroControle;
    private Long nsuTEF;
    private String comprovanteClienteCompleto;
    private String comprovanteLojaCompleto;
    private String comprovanteReduzido;

    public RetornoAprovado(IRespostaOperacaoAprovada iRespostaOperacaoAprovada) {
        this.dataAutorizacao = iRespostaOperacaoAprovada.dataHoraAutorizacao();
        this.numAutorizacao = iRespostaOperacaoAprovada.codigoAutorizacaoAdquirente();
        this.idBandeiraCartao = iRespostaOperacaoAprovada.codigoBandeiraCartao();
        this.bandeira = iRespostaOperacaoAprovada.nomeBandeiraCartao();
        this.numeroCartao = iRespostaOperacaoAprovada.numeroCartaoCliente();
        this.nsu = iRespostaOperacaoAprovada.nsuAdquirente();
        this.adiquirente = iRespostaOperacaoAprovada.nomeAdquirente();
        this.numeroControle = iRespostaOperacaoAprovada.numeroControle();
        this.nsuTEF = iRespostaOperacaoAprovada.nsuTef();

        if (iRespostaOperacaoAprovada.cupomCliente() != null) {
            comprovanteClienteCompleto = addBarraN(iRespostaOperacaoAprovada.cupomCliente());
        }
        if (iRespostaOperacaoAprovada.cupomLojista() != null) {
            comprovanteLojaCompleto = addBarraN(iRespostaOperacaoAprovada.cupomLojista());
        }
        if (iRespostaOperacaoAprovada.cupomReduzido() != null) {
            comprovanteReduzido = addBarraN(iRespostaOperacaoAprovada.cupomReduzido());
        }
    }

     public static String addBarraN(String string) {
        String saida = "";

        saida = string.replace("A\"", "A\"\n")
                .replace("\"\"", "\n")
                .replace("B\"", "B\"\n")
                .replace("C\"", "C\"\n")
                .replace("D\"", "D\"\n")
                .replace("E\"", "E\"\n")
                .replace("F\"", "F\"\n")
                .replace("G\"", "G\"\n")
                .replace("H\"", "H\"\n")
                .replace("I\"", "I\"\n")
                .replace("J\"", "J\"\n")
                .replace("L\"", "L\"\n")
                .replace("M\"", "M\"\n")
                .replace("N\"", "N\"\n")
                .replace("O\"", "O\"\n")
                .replace("P\"", "P\"\n")
                .replace("Q\"", "Q\"\n")
                .replace("R\"", "R\"\n")
                .replace("S\"", "S\"\n")
                .replace("T\"", "T\"\n")
                .replace("U\"", "U\"\n")
                .replace("V\"", "V\"\n")
                .replace("X\"", "X\"\n")
                .replace("Z\"", "Z\"\n")
                .replace("*\"", "*\"\n")
                .replace("0\"", "0\"\n")
                .replace("1\"", "1\"\n")
                .replace("2\"", "2\"\n")
                .replace("3\"", "3\"\n")
                .replace("4\"", "4\"\n")
                .replace("5\"", "5\"\n")
                .replace("6\"", "6\"\n")
                .replace("7\"", "7\"\n")
                .replace("8\"", "8\"\n")
                .replace("9\"", "9\"\n")
                .replaceAll("\"", "");

        return saida;
    }

    public Date getDataAutorizacao() {
        return dataAutorizacao;
    }

    public void setDataAutorizacao(Date dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
    }

    public String getNumAutorizacao() {
        return numAutorizacao;
    }

    public void setNumAutorizacao(String numAutorizacao) {
        this.numAutorizacao = numAutorizacao;
    }

    public Integer getIdBandeiraCartao() {
        return idBandeiraCartao;
    }

    public void setIdBandeiraCartao(Integer idBandeiraCartao) {
        this.idBandeiraCartao = idBandeiraCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getAdiquirente() {
        return adiquirente;
    }

    public void setAdiquirente(String adiquirente) {
        this.adiquirente = adiquirente;
    }

    public String getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(String numeroControle) {
        this.numeroControle = numeroControle;
    }

    public Long getNsuTEF() {
        return nsuTEF;
    }

    public void setNsuTEF(Long nsuTEF) {
        this.nsuTEF = nsuTEF;
    }

    public String getComprovanteClienteCompleto() {
        return comprovanteClienteCompleto;
    }

    public void setComprovanteClienteCompleto(String comprovanteClienteCompleto) {
        this.comprovanteClienteCompleto = comprovanteClienteCompleto;
    }

    public String getComprovanteLojaCompleto() {
        return comprovanteLojaCompleto;
    }

    public void setComprovanteLojaCompleto(String comprovanteLojaCompleto) {
        this.comprovanteLojaCompleto = comprovanteLojaCompleto;
    }

    public String getComprovanteReduzido() {
        return comprovanteReduzido;
    }

    public void setComprovanteReduzido(String comprovanteReduzido) {
        this.comprovanteReduzido = comprovanteReduzido;
    }

    @Override
    public String toString() {
        return "RetornoAprovado{" + "dataAutorizacao=" + dataAutorizacao + ", numAutorizacao=" + numAutorizacao + ", idBandeiraCartao=" + idBandeiraCartao + ", bandeira=" + bandeira + ", numeroCartao=" + numeroCartao + ", nsu=" + nsu + ", adiquirente=" + adiquirente + ", numeroControle=" + numeroControle + ", nsuTEF=" + nsuTEF + '}';
    }

}
